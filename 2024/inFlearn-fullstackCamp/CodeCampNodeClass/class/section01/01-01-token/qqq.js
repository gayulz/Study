// 함수 정의 
function getToken(){
    // Math.random()
    // 0~1사이의 랜덤수를 얻을 수 있다
    // 자리수에 맞춰서 소수점을 이동 시킨 후 나머지 숫자는 삭제
    let number = String(Math.floor(Math.random() * 1000000)).padStart(6,'0');
    console.log(number);
}

// 함수 호출 
getToken();
