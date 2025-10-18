const path = require('path');

const express = require('express');
const bodyParser = require('body-parser');

const errorController = require('./controllers/error');
const sequelize = require("./util/database");

const app = express();

app.set('view engine', 'ejs');
app.set('views', 'views');

const adminRoutes = require('./routes/admin');
const shopRoutes = require('./routes/shop');

const User = require("./models/user");
const Product = require("./models/product");
const Cart = require("./models/cart");
const CartItem = require("./models/cart-item");
const Order = require("./models/order");
const OrderItem = require("./models/order-item");

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

app.use(( req, res, next) => {
    User.findByPk(1).then(user => {
        req.user = user; // Here the user we receive is a sequelize object
        next();
    })
    .catch(err => console.log(err));
})

app.use('/admin', adminRoutes);
app.use(shopRoutes);

app.use(errorController.get404);

// product - user association
Product.belongsTo(User, { constraints: true, onDelete: 'CASCADE'});
User.hasMany(Product);
// user - cart association
User.hasOne(Cart);
Cart.belongsTo(User);
// cart - product association
Cart.belongsToMany(Product, { through: CartItem});
Product.belongsToMany(Cart, { through: CartItem});
// order - user association
Order.belongsTo(User);
User.hasMany(Order);
// order - product association
Order.belongsToMany(Product, { through: OrderItem });

sequelize
    // .sync({ force: true })
    .sync()
    .then(() => {
        // app.listen(3000);
        return User.findByPk(1);
    })
    .then(user => {
        if(!user) {
            return User.create({ name: "Gedela Sivakrishna", email: "gedelasivakrishna1@gmail.com"})
        }
        return user;
    })
    .then(user => {
        return user.createCart();
    })
    .then(cart => {
        console.log(cart);
        app.listen(3000);
    })
    .catch(err => 
    console.log(err)
);


