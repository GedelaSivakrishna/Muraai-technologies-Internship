const express = require("express");
const path = require("path");
const bodyParser = require("body-parser");

const app = express();

const shopRoutes = require("./routes/shop");
const adminRoutes = require("./routes/admin");

app.use(bodyParser.urlencoded());

app.use(shopRoutes);
app.use("/admin", adminRoutes);

app.use((req, res, next) => {
    res.status(400).sendFile(path.join(__dirname, "views", "pageNotFound.html"));
})

app.listen(3000);