const path = require('path');

const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require("mongoose");

const errorController = require('./controllers/error');
const User = require('./models/user');

const app = express();

app.set('view engine', 'ejs');
app.set('views', 'views');

const adminRoutes = require('./routes/admin');
const shopRoutes = require('./routes/shop');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

app.use((req, res, next) => {
  User.findById('68d91effa1678f4164fd3b5a')
    .then(user => {
      req.user = user;
      next();
    })
    .catch(err => console.log(err));
});

app.use('/admin', adminRoutes);
app.use(shopRoutes);

app.use(errorController.get404);

mongoose.connect("mongodb+srv://sivakrishna:PNmibMsEGh5wZP0F@cluster0.kdztwuj.mongodb.net/books_store?retryWrites=true&w=majority&appName=Cluster0").then(() => {
  console.log("Connected");
  User.findOne().then(user => {
    if(!user) {
      const newUser = new User({
        name: "Gedela Sivakrishna", 
        email:"gedelasivakrishna1@gmail.com", 
        cart: { 
          items: []
        }
      });
      newUser.save();
    };
  });
  app.listen(3000);
}).catch(err => {
  console.log("Error while connecting to database: ", err);
}) 