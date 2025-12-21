function qqq(aaa){
    console.log(aaa);
    console.log(aaa.name);
    console.log(aaa.age);
    console.log(aaa.school);
}


const name = "철수"
const age = 12
const school = "다람쥐 초등학교"
// shorthand property
const profile = { name, age, school }
// 키와 밸류가 같기 때문에 밸류를 생략함 

// 호출 방법
// 1 . 변수에 담아 보내기 
// qqq(profile);

// 2 . spread 연산자로 통째로 보내기
qqq({ name, age, school })

