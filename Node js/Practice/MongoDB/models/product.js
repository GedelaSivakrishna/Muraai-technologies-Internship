const db = require("../util/database").getDb;
const { ObjectId } = require("mongodb");

class Product {
  constructor(title, price, description, imageUrl, id) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.imageUrl = imageUrl;
    this._id = new ObjectId(id);
  }

  save() {
    return db().collection("products").insertOne(this);
  }

  update() {
    return db().collection("products").updateOne({ _id: this._id }, 
        { $set: this});
  }

  static getAllProducts() {
    return db().collection("products").find().toArray();
  }

  static getProductById(productId) {
    console.log(productId);
    return db().collection("products").findOne({ _id: new ObjectId(productId)});
  }

  static deleteProduct(productId) {
    return db().collection("products").deleteOne({ _id: new ObjectId(productId)})
                                      .then(result => {
                                        return result;
                                      })
                                      .catch(err => console.log(err));
  }

}

module.exports = Product;
