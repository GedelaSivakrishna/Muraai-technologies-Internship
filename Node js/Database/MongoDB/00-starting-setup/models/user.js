const getDb = require("../util/database").getDb;
const { ObjectId } = require("mongodb");
const Product = require("./product");

class User {
  constructor(username, email, cart, id) {
    this.name = username;
    this.email = email;
    this.cart = cart;
    this._id = id;
  }

  save() {
    let db = getDb();
    return db.collection("users").insertOne(this);
  }

  static findById(userId) {
    let db = getDb();
    return db.collection("users").findOne({ _id: new ObjectId(userId) });
  }

  addToCart(product) {
    // const updatedCart = { items: [
    //   {productId: product._id, quantity: 1}
    // ]};
    // const db = getDb();
    // return db.collection("users").updateOne({ _id: this._id },
    //   { $set: { cart: updatedCart}}
    // );

    const db = getDb();
    const isProductExist = this.cart.items.find(
      (p) => p.productId.toString() === product._id.toString()
    );
    let cartItems = this.cart.items;

    if (isProductExist) {
      cartItems = cartItems.map((cp) => {
        if (cp.productId.toString() === product._id.toString()) {
          cp.quantity = cp.quantity + 1;
        }
        return cp;
      });
    } else {
      cartItems.push({
        productId: product._id,
        quantity: 1,
      });
    }
    // save to database
    return db
      .collection("users")
      .updateOne(
        { _id: this._id },
        {
          $set: { cart: { items: cartItems } },
        }
      )
      .then((result) => console.log(result))
      .catch((err) => console.log(err));
  }

  getCart() {
    const productIds = this.cart.items.map(cItem => cItem.productId);
    const db = getDb();
    return db.collection("products").find({ _id: { $in: productIds }}).toArray()
    .then(products => {
      // remove the products from cart which are deleted
      if(products.length !== productIds.length) {
        const updatedCartItems = this.cart.items.filter(cItem => {
          if(products.findIndex(p => p._id.toString() === cItem.productId.toString()) === -1) {
            return false;
          }
          return true;
        });
        // console.log(updatedCartItems);
        db.collection("users").updateOne({ _id: this._id}, {
          $set: {cart: {items: updatedCartItems}}
        });
      }
      return products.map(p => {
        return {...p, quantity: this.cart.items.find(cp => cp.productId.toString() === p._id.toString()).quantity}
      });
    })
    .catch(err => {
      console.log("Error while fetching product details from cart: ", err);
    })
  }

  deleteCartItem(productId) {
    const db = getDb();
    const updatedCartItems = this.cart.items.filter(cItem => cItem.productId.toString() !== productId.toString());
    return db.collection("users").updateOne({_id: this._id}, 
      { $set: {cart: {items: updatedCartItems} }})
      .then((result) => {
        return result;
      })
      .catch(err => console.log("Error while deleting cart item: ",err))
  }

  placeOrder() {
    const db = getDb();
    return this.getCart().then(products => {
      const order = {
        items: products,
        user: {
          _id: this._id
        }
      };
      return db.collection("orders").insertOne(order)
                          .then(() => {
                            this.cart = { items: []};
                            return db.collection("users").updateOne({_id: this._id}, 
                              { $set: {cart: {items: []} }})
                          })
                          .catch(err => console.log(err));
    })
  };

  getOrders() {
    const db = getDb();
    return db.collection("orders")
      .find({ user: {_id: this._id}}).toArray()
      .then(result => {
        return result;
      }).catch(err => console.log(err));
  }

}

module.exports = User;