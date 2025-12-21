// 함수이지만 API 스럽다 : 검증을 한다는 의미
// 정의 하고 처리하는 로직 : 백엔드 영역에서 처리 

// 안 좋은 코드 예시
/*
function createTokenOfPhone(qqq){ // qqq는 매개변수(parameter)
    // 1. 휴대폰 번호 자릿 수 맞는지 확인 (10~11자리)
    if(qqq.length > 10){
        if(qqq.length <= 11){
            // 정상 로직일때
            // 2. 휴대폰 토큰 6자리 생성 하기
            let result = String(Math.floor(Math.random() * 1000000)).padStart(6,'0');
            // 3. 휴대폰 번호에 토큰 전송하기 
            console.log(`휴대폰번호 [${qqq}] 인증번호 : ${result}를 전송합니다.`); 
        } else {
            console.log("에러 발생, 핸드폰 번호를 다시 입력하세요");
        }
    } else { 
        console.log("에러 발생, 핸드폰 번호를 다시 입력하세요");
    }
}
// 브라우저에서 에서 클릭시 함수가 실행된다
// 호출 : 프론드엔드 영역에서 호출 
createTokenOfPhone("01012341234")
// ()안에 들어가는건 인자(argument )
*/


// 좋은 예시로 바꿔보자 
function createTokenOfPhone(qqq){ // qqq는 매개변수(parameter)
    // 1. 휴대폰 번호 자릿 수 맞는지 확인 (10~11자리)
    // 에러인경우
    if(qqq.length <= 9 && qqq.length >= 11) { 
        console.log("에러 발생, 핸드폰 번호를 다시 입력하세요");
        return 
        // 리턴을 만나는 순간 아래 코드는 진행하지 않는다 
        // 이런 패턴을 early-exit 패턴이라고 한다
    }
    // 정상 로직일때
    // 2. 휴대폰 토큰 6자리 생성 하기
    let result = String(Math.floor(Math.random() * 1000000)).padStart(6,'0');
    // 3. 휴대폰 번호에 토큰 전송하기 
    console.log(`휴대폰번호 [${qqq}] 인증번호 : ${result}를 전송합니다.`); 
}

createTokenOfPhone("01012341234")

