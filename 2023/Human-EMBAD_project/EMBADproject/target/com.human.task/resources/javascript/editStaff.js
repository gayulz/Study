
var editStaffForm = document.getElementById('editStaffForm');

if (editStaffForm) {
    editStaffForm.addEventListener('submit', async function (event) {
        event.preventDefault();
        var staffPass = document.getElementById('inputPassword5').value;
        var phoneNumber1 = document.getElementById('phoneNumber1').value;
        var phoneNumber2 = document.getElementById('phoneNumber2').value;
        var phoneNumber3 = document.getElementById('phoneNumber3').value;
        var staffEmail = document.getElementById('staffEmail').value; // staffEmail의 id를 확인하세요.

        if (!isValidPassword(staffPass)) {
            alert('비밀번호가 유효하지 않습니다.');
            return;
        }

        if (!isValidPhoneNumber(phoneNumber1, phoneNumber2, phoneNumber3)) {
            alert('전화번호가 유효하지 않습니다.');
            return;
        }

        var staffPhone = phoneNumber1 + phoneNumber2 + phoneNumber3; // '-' 제거가 필요 없다면 이대로 사용

        // 유효성 검사를 통과했다면 데이터를 컨트롤러에게 전달합니다.
        var sendData = {
            staffEmail: staffEmail,
            staffPass: staffPass,
            staffPhone: staffPhone
        };

        try {
            let res = await fetch('/editStaffInfo', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(sendData)
            });
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            let jsonText = await res.json();
            if (jsonText.result == true){
                alert("정보 수정 완료\n초기화면으로 돌아갑니다");
                goToInfo();
            }
        } catch(Error) {
            console.log(Error);
        }
    });
}