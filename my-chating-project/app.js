const express = require('express')
const mongoose = require('mongoose')
require('dotenv').config()
const cors = require('cors')
const app = express();
app.use(cors())

mongoose.connect(process.env.DB, {
    useNewUrlParser : true,
    useUnifiedTopology : true
})
    .then(()=> console.log("database connected Successfully"))
    .catch(err => { console.error(err)});

module.exports = app