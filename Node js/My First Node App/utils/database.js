const mysql = require("mysql2");

const pool = mysql.createPool({
    database: "node-course",
    user: "root",
    password: "root",
    host: "localhost"
});

module.exports = pool.promise();