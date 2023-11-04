const email = "codecamp@gmail.com"
// undefined
email
// 'codecamp@gmail.com'
email.includes("@")
// true
email.split("@")
// (2) ['codecamp', 'gmail.com']
email.split("@")[0]
// 'codecamp'
email.split("@")[1]
// 'gmail.com'
let userEmail = email.split("@")[0]
// undefined
userEmail
// 'codecamp'
let company = email.split("@")[1]
// undefined
let maskingEmail = []
// undefined
    maskingEmail.push(userEmail[0])
// 1
    maskingEmail.push(userEmail[1])
// 2
    maskingEmail.push(userEmail[2])
// 3
    maskingEmail.push(userEmail[3])
// 4
maskingEmail
// (4) ['c', 'o', 'd', 'e']
    maskingEmail.push("*")
// 5
    maskingEmail.push("*")
// 6
    maskingEmail.push("*")
// 7
    maskingEmail.push("*")
// 8
maskingEmail
// (8) ['c', 'o', 'd', 'e', '*', '*', '*', '*']
maskingEmail.join("")
// 'code****'
maskingEmail
// (8) ['c', 'o', 'd', 'e', '*', '*', '*', '*']
maskingEmail.join("")
// 'code****'
maskingEmail.join("")+"@"+company
// 'code****@gmail.com'
let result = maskingEmail.join("")+"@"+company
// undefined
result
// 'code****@gmail.com'