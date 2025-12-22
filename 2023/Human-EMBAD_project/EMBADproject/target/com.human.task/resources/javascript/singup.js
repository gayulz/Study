var prmNumber , prmName;

// 회원가입 버튼 입력 시 처리 로직 수정
document.getElementById('userSend').addEventListener('submit', async function (event) {
    event.preventDefault();
    console.log("event 실행 userSend");
    let sendData = processForm();
    if(!sendData){
        return alert('유효성 검사 실패');
    }

    // 데이터를 컨트롤러에게 전달함
    try {
        let res = await fetch('/sendUserData', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(sendData)
        });
        if (!res.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        let jsonText = await res.json();
        if (jsonText.result == true){
            alert("회원가입 완료\n초기화면으로 돌아갑니다");
            goToInfo();
        }
    } catch(Error) {
        console.log(Error);
    }
});

/*-------------------------------------------------------------------------------------*/


// 비밀번호 유효성 검사 및 모든 필드 입력 검사 후 객체생성 로직
// 리턴값 : controller에게 전달할 object
function processForm() {
    var elements = getFormElements();
    if (validateFormElements(elements)) {
        return createUserObject(elements);
    }
}


/**
 * DOM 요소 전체 가져오기 : 리턴값 object
 * */
function getFormElements() {
    let temp = {
        userType: document.getElementById('userType').value,
        staffName: document.getElementById('staffName').value,
        staffEmail: document.getElementById('staffEmail').value,
        staffPass: document.getElementById('staffPass').value,
        phoneNumber1: document.getElementById('phoneNumber1').value,
        phoneNumber2: document.getElementById('phoneNumber2').value,
        phoneNumber3: document.getElementById('phoneNumber3').value,
        prmName: prmName ? prmName : null,
        prmNumber: prmNumber ? prmNumber : null,
        dutyNumber: dutyNumber? dutyNumber: null,
        dutyName: dutyName ? dutyName : null
    };
    console.log(temp)
    return temp;
}


// 필드 유효성 체크 : 리턴값 Boolean
function validateFormElements(elements) {
    if (
        !elements.staffName ||
        !elements.staffEmail ||
        !elements.phoneNumber1 ||
        !elements.phoneNumber2 ||
        !elements.phoneNumber3 ||
        (elements.userType === '1' && (!elements.prmNumber || !elements.prmName)) ||
        (elements.userType === '2' && (!elements.dutyName || !elements.dutyNumber)) ||
        !isValidPassword(elements.staffPass)) {
        return false; // 유효성 체크 실패
    }
    // 전화번호 유효성 검사 추가
    if (!isValidPhoneNumber(elements.phoneNumber1, elements.phoneNumber2, elements.phoneNumber3)) {
        return false; // 전화번호 유효성 체크 실패
    }
    return true; // 유효성 체크 성공
}


// 비밀번호 유효성 체크
function isValidPassword(password) {
    if (password.length < 8) {
        alert("비밀번호 길이가 너무 짧습니다 ")
        return false; // 비밀번호 길이가 8자 미만
    }
    if (/[`'"\&\$]/.test(password)) {
        alert(" `, ', \", &, $ 를 포함 불가 ")
        return false; // 특수문자 `, ', ", &, $ 포함
    }
    return true; // 유효한 비밀번호
}



// 구급대원 가입으로 목록 변경시 데이터 추출
// 리스너를 통해 자동으로 계속 전달옴
document.getElementById('dutyNameList').addEventListener('change', function() {
    var selectedOption = this.options[this.selectedIndex];
    dutyNumber = selectedOption.value;
    dutyName = selectedOption.text;
});



// 전달 객체 생성 수정: 전화번호 형식 조정
function createUserObject(elements) {
    var phone = `${elements.phoneNumber1}-${elements.phoneNumber2}-${elements.phoneNumber3}`;
    return {
        userType: elements.userType === '1' ? 1 : 2, // 병원이면 컨트롤러가 서비스 방향을 정할 수 있도록 1 , 구급이면 2 로 전달
        dutyName: elements.userType === '2' ? elements.dutyName : null,
        hpid: elements.userType === '2' ? elements.dutyNumber : null,
        prmName: elements.userType === '1' ? elements.prmName : null,
        prmNumber: elements.userType === '1' ? elements.prmNumber : null,
        staffEmail: elements.staffEmail,
        staffName: elements.staffName,
        staffPass: elements.staffPass,
        staffPhone: phone.replace(/-/g, '') // 전화번호에서 '-' 제거
    };
}

// 전화번호 유효성 검사
function isValidPhoneNumber(phoneNumber1, phoneNumber2, phoneNumber3) {
    var phoneRegex = /^\d{2,3}$/; // 지역번호 형식 (2~3자리 숫자)
    var phoneRegexMid = /^\d{3,4}$/; // 중간자리 형식 (3~4자리 숫자)
    var phoneRegexLast = /^\d{4}$/; // 마지막자리 형식 (4자리 숫자)

    if (!phoneRegex.test(phoneNumber1)) {
        alert("전화번호의 지역번호가 올바르지 않습니다.");
        return false;
    }
    if (!phoneRegexMid.test(phoneNumber2)) {
        alert("전화번호의 중간자리가 올바르지 않습니다.");
        return false;
    }
    if (!phoneRegexLast.test(phoneNumber3)) {
        alert("전화번호의 마지막자리가 올바르지 않습니다.");
        return false;
    }
    return true;
}

