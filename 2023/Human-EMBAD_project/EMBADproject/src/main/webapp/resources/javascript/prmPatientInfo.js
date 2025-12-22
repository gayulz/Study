
// 드롭다운 옵션 버튼 생성 이벤트
document.querySelectorAll('.select__menu select').forEach(select => {
    select.addEventListener('change', function () {
        if (this.selectedIndex > 0) { // 첫번째 기본 옵션을 제외한 선택 시
            var selectOption = this.options[this.selectedIndex];
            createButton(selectOption.value, selectOption.text);
            createInputField(selectOption.value, selectOption.text);

        }
    });
});

function createButton(value, text) {
    var selectedOptions = document.getElementById('selectedOptions');
    if (selectedOptions) {
        var button = document.createElement('button');
        button.name = value;
        button.textContent = text;
        button.type = 'button';
        button.className = 'btn btn-info';
        button.style.margin = '5px';
        button.addEventListener('click', function () {
            let existingInput = inputFields.querySelector('input[name="' + this.name + '"]');
            this.remove(); // 버튼 클릭 시 삭제
            // 동일한 이름의 이전 입력 필드를 제거합니다
            if (existingInput) {
                inputFields.removeChild(existingInput);
            }
        });
        // ... 기존 코드 ...
        selectedOptions.appendChild(button);
    }
}

function createInputField(value, text) {
    let inputFields = document.getElementById('inputFields');
    let input = document.createElement('input');
    input.type = 'hidden'; // 입력 필드를 숨깁니다
    input.name = value;
    input.value = text;
    inputFields.appendChild(input);
}
