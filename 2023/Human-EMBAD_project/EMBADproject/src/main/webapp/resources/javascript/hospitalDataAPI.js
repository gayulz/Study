let hospital = document.querySelector("#dutyNameList");
let city = document.querySelector("#city");
let hpidHidden = document.querySelector('#hpidHidden');
hospital.addEventListener('change', showHpidfn);

var jsonData, dutyNumber , dutyName;
// 병원정보를 요청해서 가져오는 로직
if (city) {
    city.addEventListener('change', async (event) => {
        event.preventDefault();
        let param = city.value;
        let url = '/getHospitalData';
        let option = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({city: param})
        };
        try {
            let res = await fetch(url, option);
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            jsonData = await res.json();
            hospital.innerHTML = '';

            let defaultOption = document.createElement("option");
            defaultOption.value = '';
            defaultOption.textContent = '병원 선택';
            hospital.appendChild(defaultOption);

            jsonData.forEach(item => {
                let optionElement = document.createElement("option");
                optionElement.value = item.hpid;
                optionElement.textContent = `${item.dutyName}`;
                hospital.appendChild(optionElement);
            });
        } catch (error) {
            console.log('Error:', error);
        }
    });
} else {
    console.log("City element not found");
}

// 기관코드 갱신 함수
function showHpidfn() {
    let selectedOption = this.options[this.selectedIndex];
    dutyNumber = selectedOption.value;
    dutyName = selectedOption.text;
    hpidHidden.style.display = 'block';
    hpidHidden.innerHTML = `기관ID : ${dutyNumber}`; // 선택된 value 값으로 내용 변경
}