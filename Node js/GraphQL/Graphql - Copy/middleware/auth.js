const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
  const authHeader = req.get('Authorization');
  if (!authHeader) {
    this.isAuth = false;
    next();
  } else {
    const token = authHeader.split(' ')[1];
    let decodedToken;
    try {
      decodedToken = jwt.verify(token, 'mysecretsecretsecret');
    } catch (err) {
      this.isAuth = false;
      next();
    }
    if (!decodedToken) {
      this.isAuth = false;
      next();
    } else {
      req.userId = decodedToken._id;
      req.isAuth = true;
      next();
    }
  }
};
