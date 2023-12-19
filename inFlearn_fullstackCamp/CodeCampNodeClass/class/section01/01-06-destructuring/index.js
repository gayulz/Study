// 구조분해할당 = 비구조화할당

//예제
const profile = {
    name : "철수",
    age : 12,
    school : "다람쥐 초등학교"
}

const { name, school } = profile

console.log(school)

// 1. 일반변수 전달하기 
function zzz(aaa){
    console.log(aaa)
}

zzz("사과")