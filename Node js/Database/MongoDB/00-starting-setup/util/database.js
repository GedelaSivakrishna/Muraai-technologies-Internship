const mongodb = require("mongodb");
const MongoClient = mongodb.MongoClient;

let _db;

const mongoConnect = (callback) => {
  MongoClient.connect(
    "mongodb+srv://sivakrishna:PNmibMsEGh5wZP0F@cluster0.kdztwuj.mongodb.net/shop?retryWrites=true&w=majority&appName=Cluster0"
  )
    .then(client => {
      _db = client.db();
      console.log("Connected!");
      callback();
    })
    .catch((err) => console.log(err));
};

function getDb() {
  if(_db) {
    return _db;
  }
  throw "Error while connecting to database!";
}

exports.mongoConnect = mongoConnect;
exports.getDb = getDb;