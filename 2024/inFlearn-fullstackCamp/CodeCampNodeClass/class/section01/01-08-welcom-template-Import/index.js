import { sendToEmail, isEmail, emailTemplate } from './email.js'

function createUser({ name, age, school, email }){
    // 1. 이메일 유효성 체크 
    if(!(isEmail(email))) return
    // 2. 가입 환영 템플릿 만들기  
    const sendMail = emailTemplate({ name, age, school, email })
    // 3. 이메일에 가입환영 템플릿 전송
    sendToEmail(sendMail);   
}

const name = "철수"
const age = 8
const school = "다람쥐 초등학교"
const email = "a.a@gmail.com"
 
createUser({ name, age, school, email})