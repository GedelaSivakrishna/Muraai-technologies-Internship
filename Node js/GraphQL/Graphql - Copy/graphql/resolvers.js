const bcrypt = require("bcryptjs");
const validator = require("validator");
const jwt = require("jsonwebtoken");

const User = require("../models/user");
const Post = require("../models/post");
const post = require("../models/post");

module.exports = {
    // profile() {
    //     return {
    //         name: "Gedela Sivakrishna",
    //         age: 22.7
    //     }
    // }

    createUser: async function({ userInput }, req) {
        const errors = [];
        if (!validator.isEmail(userInput.email)) {
            errors.push({
                message: "Invalid email"
            })
        }

        if(validator.isEmpty(userInput.password) || !validator.isLength(userInput.password, { min: 5 })) {
            errors.push({
                message: "Password must be atleast 5 characters"
            })
        }

        if(errors.length) {
            const error = new Error("Invalid input");
            error.data = errors;
            error.code = 422;
            throw error;
        }

        const isExistingUser = await User.findOne({ email: userInput.email });
        if (isExistingUser) {
            const error = new Error("user already registered with email ", userInput.email);
            throw error;
        }

        const hashedPw = await bcrypt.hash(userInput.password, 12);

        const newUser = new User({
            email: userInput.email,
            name: userInput.name,
            password: hashedPw
        });

        const createdUser = await newUser.save();
        return createdUser;
    },

    login: async function({ email, password }) {
        const user = await User.findOne({ email: email });
        if(!user) {
            const error = new Error("User not found.");
            error.code = 401;
            throw error;
        }

        const isEqual = await bcrypt.compare(password, user.password);
        if(!isEqual) {
            const error = new Error("Password is incorrect");
            error.code = 401;
            throw error;
        }

        const token = jwt.sign({
            _id: user._id.toString(),
            email: user.email
        }, "mysecretsecretsecret", { expiresIn: "1h" });

        return { token: token, _id: user._id.toString() };
    },

    createPost: async function({ postInput }, req) {
        if(!req.isAuth) {
            const error = new Error("Not authenticated");
            error.code = 401;
            throw error;
        }
        const errors = [];
        if (validator.isEmpty(postInput.title) || !validator.isLength(postInput.title, { min: 5 })) {
            errors.push({
                message: "Invalid title"
            });
        }
        
        if (validator.isEmpty(postInput.content) || !validator.isLength(postInput.content, { min: 5 })) {
            errors.push({
                message: "Invalid content"
            });
        }

        if(errors.length) {
            const error = new Error("Invalid input");
            error.data = errors;
            error.code = 422;
            throw error;
        }
        const user = await User.findById(req.userId);
        if(!user) {
            const error = new Error("Invalid user");
            error.code = 401;
            throw error;
        }
        const post = new Post({
            title: postInput.title,
            content: postInput.content,
            imageUrl: postInput.imageUrl,
            creator: user
        });

        const createdPost = await post.save();
        user.posts.push(createdPost);
        await user.save();
        return {...createdPost._doc, _id: createdPost._id.toString(), createdAt: createdPost.createdAt.toISOString(), updatedAt: createdPost.updatedAt.toISOString()};
    },

    getPosts: async function({ page }, req) {
        if (!req.isAuth) {
            const error = new Error("Not Authenticated");
            error.code = 401;
            throw error;
        }

        const user = await User.findById(req.userId);
        if (!user) {
            const error = new Error("User not found");
            error.code = 401;
            throw error;
        }

        const currentPage = page || 1;
        const perPage = 2;
        const posts = await Post.find().populate('creator').sort({ createdAt: -1 }).skip((currentPage - 1) * perPage).limit(perPage);
        const totalPosts = await Post.find().countDocuments();

        return { posts: posts.map(post => { 
            return { ...post._doc, 
                _id: post._id.toString(), 
                createdAt: post.createdAt.toISOString(), 
                updatedAt: post.updatedAt.toISOString() }
             }), 
             totalPosts: totalPosts
        };
    }

}