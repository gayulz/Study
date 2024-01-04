const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
    name : {
        type : String, 
        required : [true, "이름을 꼭 입력하세요"], 
        unique : true, 
    }, 
    token : {
        type : String, 
    }, 
    online : {
        type : Boolean, 
        default : false,
    },
});
module.exports = mongoose.model("User", userSchema);