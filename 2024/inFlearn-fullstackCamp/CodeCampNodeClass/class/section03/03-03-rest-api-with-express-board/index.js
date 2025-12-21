import express from 'express' // 요즘 방식 -> module
import createTokenOfPhone from './phone.js'
const app = express()
app.use(express.json()) // 예전에는 bodyParser를 사용했다. 지금은 express로 주로 사용함 


app.get('/boards', function(req, res){
    //조회를 했을때 데이터베이스에서 목록을 가져와야한다
    // 1. DB에 접속 후 데이터 조회 : 데이터를 조회했다고 가정한다
    const result = [
        { number : 1 , writer : "김춘식" , title : "춘식이입니당" , contents : "냐용냐용냐용냐용"},
        { number : 2 , writer : "라이언" , title : "라이언입니당" , contents : "어흥어흥어흥어흥"},
        { number : 3 , writer : "어피치" , title : "춘식이입니당" , contents : "복숭봉숭복숭"}
    ]

    // 2. DB에서 꺼내온 결과를 브라우저에 응답으로 주기 
    res.send(result)
}) 

app.post('/boards', function(req, res){
   // 1. 브라우저에서 보내준 데이터 확인하기
    console.log(req) 
    console.log("====================================")
    console.log(req.body) 
    

    // 2. DB에 접속 후 데이터를 저장 : 저장했다 가정하자
    // 3. DB에 저장된 결과를 브라우저 응답으로 주기 
    res.send('게시물 등록 성공')
}) 

app.post("/tokens/phone", function(req, res) {
    const flag = createTokenOfPhone(req.body.phone)
    if (flag != false){ res.send(`인증번호 : ${flag}`) } 
    else { res.send('인증 실패')}
})
app.listen(3000)
