const db = require("../util/database").getDb;
const { ObjectId } = require("mongodb");
const Product = require("./product");

class User {
  constructor(name, email, cart, id) {
    this.name = name;
    this.email = email;
    this.cart = cart;
    this._id = new ObjectId(id)
  }

  static findById(userId) {
    return db().collection("users").findOne({ _id: new ObjectId(userId)});
  }

  static getCart(userId) {
    return this.findById(userId)
                           .then(user => {
                            const productIds = user.cart.items.map(cItem => cItem.productId);
                            if(productIds.length > 0) {
                              return db().collection("products").find({ _id : {$in: productIds}}).toArray()
                                                    .then(products => {
                                                      // delete the products in cart, if they are deleted by admin
                                                      if(products.length < productIds.length) {
                                                        const deletedProductIds = productIds.filter(pId => 
                                                           !products.some(p => p._id.toString() === pId.toString())
                                                        )
                                                        const updatedCartItems = user.cart.items.filter(cItem => !deletedProductIds.includes(cItem.productId));
                                                        db().collection("users").updateOne({ _id: user._id}, 
                                                                { $set: { cart: {items: updatedCartItems}}}
                                                        );
                                                      }
                                                      return products.map(p => {
                                                        return {
                                                          _id: p._id,
                                                          title: p.title, 
                                                          quantity: user.cart.items.find(item => item.productId.toString() === p._id.toString()).quantity };
                                                      })
                                                    })
                                                    .then(cartProducts => {
                                                      return cartProducts;
                                                    })
                                                    .catch(err => console.log(err));
                            }
                            else {
                              return [];
                            }
                           })
                           .catch(err => console.log(err));
  }

  addToCart(productId) {
    const cartItems = this.cart.items;
    const productIds = cartItems.map(cItem => cItem.productId);
    // const isProductExists = productIds.indexOf(new ObjectId(productId));
    const isProductExists = productIds.find(pId => pId.toString() === productId.toString());
    const updatedCartItems = [...cartItems];
    // const 
    if(!isProductExists) {
      updatedCartItems.push({productId: new ObjectId(productId), quantity: 1});
    }
    else {
      updatedCartItems.forEach(cItem => {
        if(cItem.productId.toString() === productId.toString()) {
          cItem.quantity = cItem.quantity + 1;
        }
      });
    }
    return db().collection("users").updateOne({ _id: this._id}, 
          { $set: { cart: {items: updatedCartItems}}}
    );
  }

  deleteCartProduct(productId) {
    const updatedCartItems = this.cart.items.filter(cItem => cItem.productId.toString() !== productId.toString());
    return db().collection("users").updateOne({ _id: this._id}, 
      { $set: {cart: {items: updatedCartItems}}}
    )
    .then(result => {
      return result;
    })
    .catch(err => {
      console.log("Error while deleting product from cart: ", err);
    })
  }

  createOrder() {
    const productIds = this.cart.items.map(cItem => cItem.productId);
    return db().collection("products").find({ _id: { $in: productIds}}).toArray()
                    .then(cartProducts => {
                      const order = {
                        userId: this._id,
                        products: cartProducts.map(cP => {
                          return {
                            _id: cP._id,
                            title: cP.title,
                            quantity: this.cart.items.find(cItem => cItem.productId.toString() === cP._id.toString()).quantity,
                          }
                        })
                      };
                      this.cart.items = [];
                      // empty user cart in db
                      db().collection("users").updateOne({_id: this._id}, 
                            {$set: {cart: {items: []}}}
                      );
                      return db().collection("orders").insertOne(order);
                    })
                    .then(createdOrder => {
                      return createdOrder;
                    })
                    .catch(err => console.log(err));
  }

  getOrders() {
    return db().collection("orders").find({ userId: this._id}).toArray();
  }

}

module.exports = User;
