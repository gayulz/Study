// 가입환영 이메일 템플릿을 만들어보자
function getWelcomeTemplate(object){
    const myTemplate = `
     <html>
        <body> 
            <h1> ${object.name} 님 가입을 환영합니다 </h1>
            <hr />
            <div> 이름 : ${object.name} </div>
            <div> 나이 : ${object.age} 살 </div>
            <div> 학교 : ${object.school} 초등학교 </div>
            <div> 가입일 : ${object.summitDate} </div>
        </body>
     </html>
    `
    console.log(myTemplate);
}

const insertObject = {
    name : "철수",
    age : 12,
    school : "다람쥐", 
    summitDate : new Date()
}

getWelcomeTemplate()
