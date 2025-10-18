const express = require("express");

const app = express();

// app.use((req, res, next) => {
//     console.log("1st middleware");
//     next();
// });

// app.use((req, res, next) => {
//     console.log("2nd middleware");
//     res.send("Hi, I'm Sivakrishna");
// })

app.use("/users", (req, res, next) => {
    res.send("This page lists users.");
});

app.use("/", (req, res, next) => {
    res.send("This is home page");
});

app.listen(3000);