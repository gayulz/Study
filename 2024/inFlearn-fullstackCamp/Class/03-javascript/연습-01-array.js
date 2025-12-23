let classmates
// undefined
let cl
// undefined
let classmates = ["철수", "영희", "훈이"]
// undefined
classmates[0]
// '철수'
classmates[1]
// '영희'
classmates[2]
// '훈이'
// classma
// VM317:1 Uncaught ReferenceError: classma is not defined
    // at <anonymous>:1:1
// (익명) @ VM317:1
classmates.includes("훈이")
// true
classmates.includes("맹이")
// false
classmates.length
// 3
classmates.push("맹구")
// 4
classmates.includes("맹구")
// true
// classmateㄴ
// VM666:1 Uncaught ReferenceError: classmateㄴ is not defined
    // at <anonymous>:1:1
// (익명) @ VM666:1
classmates
// (4) ['철수', '영희', '훈이', '맹구']
classmates.pop("영희")
// '맹구'
classmates
// (3) ['철수', '영희', '훈이']
classmates.pop("")
// '훈이'
classmates
// (2) ['철수', '영희']