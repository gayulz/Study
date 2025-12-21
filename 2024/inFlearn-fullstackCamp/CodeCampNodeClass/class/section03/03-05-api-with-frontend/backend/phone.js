// 퍼샤드패턴 적용을 해보자

export default function createTokenOfPhone(myphone) {
    if (checkPhone(myphone)) {
      const mytoken = getToken()
      const token = sendTokenToSMS(myphone, mytoken)
      return token
    } 
  }
    
  // 핸드폰 검증 함수
  function checkPhone(myphone) {
      if (myphone.length <= 9 && myphone.length >= 11) {
        console.log("에러 발생, 핸드폰 번호를 다시 입력하세요");
        return false;
      } return true;
    }
    
    // 토큰을 만드는 함수
    function getToken() {
      let result = String(Math.floor(Math.random() * 1000000)).padStart(6, "0");
      return result
    }
    
    // 핸드폰 번호에 토큰 전송
    function sendTokenToSMS(myphone, result) {
      console.log(`휴대폰번호 [${myphone}] 인증번호 : ${result}를 전송합니다.`);
      return result
    }