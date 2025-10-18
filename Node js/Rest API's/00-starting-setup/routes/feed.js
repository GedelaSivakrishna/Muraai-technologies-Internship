const express = require("express");

const feedController = require("../controllers/feed");

const router = express.Router();

// Define the routes
router.get("/posts", feedController.getPosts);

router.post("/post", feedController.createPost);

module.exports = router;