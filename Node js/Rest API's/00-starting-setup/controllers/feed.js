exports.getPosts = (req, res, next) => {
    res.status(200).json({
        posts: [
            {
                title: "First post",
                content: "This is first post!"
            }
        ]
    });
}

exports.createPost = (req, res, next) => {
    console.log(req.body);
    const title = req.body.title;
    const content = req.body.content;
    // create post in db
    res.status(201).json({
        message: "Post created successfully!",
        post: {
            id: Date.now().toString(),
            title: title,
            content: content,
        }
    });
}