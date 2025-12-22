let randomNumber;
document.getElementById('emailSend').addEventListener('submit', emailVerification)

// 이메일 유효성 검샤 + 이메일 중복 검사 후 발송 로직
async function emailVerification() {
    event.preventDefault();
    let userEmail = document.getElementById('staffEmail').value;
    // 입력된 이메일 유효성 검사 - 정상
    if (!isEmail(userEmail)) { return alert("알맞은 이메일방식이 아닙니다.") }
    // 가입된 이메일이 있는지 검사
    if(!checkEmailDuplication(userEmail)){ return alert("중복된 이메일입니다.")}
    // 유효성&중복검사 정상 : 랜덤 인증번호 생성
    randomNumber = String(Math.floor(Math.random() * 1000000)).padStart(6,'0');
    // 이메일 발송
    try {
        const emailSent = await sendToEmail(userEmail, randomNumber);
        if(emailSent){
            alert("이메일 발송 성공");
        } else {
            alert("이메일 발송 실패");
        }
    } catch (error) {
        console.error('Error during email sending:', error);
    }
}

/**
 이메일 발송 함수
 */
async function sendToEmail(email, randomNumber) {
    let name = document.getElementById('staffName').value;
    let data = {
        name: name,
        email: email,
        randomNumber: randomNumber
    };
    try {
        let response = await fetch('/sendMail', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        } else {
            let result = await response.json();
            if (result === 'true') {
                return true;
            } else {
                console.error('Email sending failed', result);
                return false;
            }
        }
    } catch (error) {
        console.error('Error:', error);
        return false;
    }
}


/** 이메일 중복 확인 함수 */
function checkEmailDuplication(email){
    // GET 요청 URL 생성
    let url = `/emailDuplication?email=${encodeURIComponent(email)}`;
    // fetch 사용하여 GET 요청을 보냄
    let res = async () => {
        try {
            await fetch(url)
                .then(response => response.json())
                .then(data => {
                    if (data.isDuplicated) {
                        alert("이메일이 중복됩니다.");
                        return false;
                    } else {
                        return true;
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        } catch (error){
            console.error('Error : ' , error);
        }
    }
    return res;
}


/**
 이메일 유효성 리턴 함수
 @param : String
 @return : boolean
 */
function isEmail(email) {
    var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return regex.test(email);
}


/**이메일발송 인증문자 일치확인*/
function isEmailSendNumber(){
    let inputNumber = document.getElementById('inputNumber').value;
    let checkBtn = document.getElementById('checkBtn');
    if (inputNumber == randomNumber){
        checkBtn.disabled=true;
        checkBtn.value='인증 완료'
    } else { alert('다시 입력하세요')
        checkBtn.disabled=false;
    }
}