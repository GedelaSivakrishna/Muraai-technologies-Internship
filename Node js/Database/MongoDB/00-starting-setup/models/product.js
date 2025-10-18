const { ObjectId } = require("mongodb");
const mongodb = require("mongodb");
const getDb = require("../util/database").getDb;

class Product {
  constructor(title, price, description, imageUrl, userId) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.imageUrl = imageUrl;
    this.userId = userId;
  }

  save() {
    const db = getDb();
    return db
      .collection("products")
      .insertOne(this)
      .then((result) => {
        console.log(result);
      })
      .catch((err) => console.log(err));
  }

  static fetchAll() {
    const db = getDb();
    return db
      .collection("products")
      .find()
      .toArray()
      .then((products) => {
        return products;
      })
      .catch((err) => console.log(err));
  }

  // static fetchCartProducts(productIds) {
  //   const db = getDb();
  //   const products = [];
  //   productIds.forEach(id => {
  //     db.collection("products").findOne({ _id: new ObjectId(id)}).then(product => {
  //       products.push(product);
  //     })
  //   })
  //   return Promise.resolve(products);
  // }

  static findById(prodId) {
    const db = getDb();
    return (
      db
        .collection("products")
        // .find({ _id: new mongodb.ObjectId(prodId)})
        .find({ _id: new ObjectId(prodId) })
        // .find({ _id: new createFromTime()})
        .next()
        .then((product) => {
          // console.log(product);
          return product;
        })
        .catch((err) => console.log(err))
    );
  }

  static update(product) {
    const db = getDb();
    console.log("Data to be updated: ", product);
    return db
      .collection("products")
      .updateOne({ _id: new ObjectId(product._id) }, { $set: product })
      .then((result) => {
        console.log(result);
      })
      .catch((err) => console.log(err));
  }
  
  static delete(prodId) {
    const db = getDb();
    return db.collection("products").deleteOne({ _id: new ObjectId(prodId)});
  }

}


module.exports = Product;
