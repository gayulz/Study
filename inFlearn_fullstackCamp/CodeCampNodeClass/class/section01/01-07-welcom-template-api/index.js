function createUser({ name, age, school, email, createAd }){
    // 1. 이메일 유효성 체크 
    if(!(isEmail(email))) return
    // 2. 가입 환영 템플릿 만들기  
    const sendMail = emailTemplate({ name, age, school, email, createAd })
    // 3. 이메일에 가입환영 템플릿 전송
    sendToEmail(sendMail);   
}


// 템플릿 전송
function sendToEmail(temp){
    console.log(temp)
}

// 이메일 유효성 체크
// 1-1 : 이메일 입력 데이터 존재 여부
// 1-2 : @ 포함여부
function isEmail(email){
    if(email === undefined || email.includes("@") === false) {
        console.log("에러 발생 이메일을 다시 입력하세요")
        return false;
    }
    else return true;
}


// 가입 환영 템플릿 만들기
function emailTemplate({ name, age, school, email, createAd }){
    const emailTemp = `
    <html>
    <body>
        <h1> ${name} 님 가입을 환영합니다 </h1>
        <hr />
        <div> 가입정보 </div>
        <div> 이름 : ${name} </div>
        <div> 나이 : ${age} 살 </div>
        <div> 학교 : ${school} </div>
        <div> 이메일 : ${email} </div>
        <div> 가입일 : ${createAd} </div>
    </body>
    </html>
    `
    return emailTemp
}

const name = "철수"
const age = 8
const school = "다람쥐 초등학교"
const email = "a.a@gmail.com"
const createAd = "2023-12-12"
 
createUser({ name, age, school, email, createAd })