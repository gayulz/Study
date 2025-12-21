// const express = require('express') 예전 방식 -> commonjs

import express from 'express' // 요즘 방식 -> module

const app = express()

// get 방식에 app을 만들겠다 , 엔드포인트는 / 기준이다.
// get 방식에 app을 만들겠다 , 엔드포인트는 / 기준이다.
app.get('/qqq', function(req, res){
    res.send('Welcome 익스프레스으!!!!!!')
}) // 이 함수는 미들웨어 함수 

app.listen(3000)
// 3000번은 포트번호
// listen은 기다린다 라는 의미도 있다 
// 

