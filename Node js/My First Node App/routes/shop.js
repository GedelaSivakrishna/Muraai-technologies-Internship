const path = require("path");

const express = require("express");
const router = express.Router();

// root project directory path
const rootDir = require("../utils/path");

router.get("/",(req, res, next) => {
    res.sendFile(path.join(rootDir, "views", "shop.html"));
});

module.exports = router;