const Sequelize = require("sequelize");

const sequelize = new Sequelize("node_course", "root", "root", {
    host: "localhost",
    dialect: "mysql"
    });

module.exports = sequelize;