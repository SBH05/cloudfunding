// 입력창에 입력이 발생할 때 남은 글자 수 계산
function updateCharacterCount() {
    var inputElement = document.getElementById('putIn-title-text');
    var characterCountElement = document.getElementById('characterCount');

    var remainingCharacters = 40 - inputElement.value.length;

    characterCountElement.textContent = remainingCharacters + '자 남음';
}

// 프로젝트 종료일
function formatDateInput(inputElement) {
    var inputValue = inputElement.value.replace(/\D/g, '');

    if (inputValue.length >= 8) {
        var formattedDate = inputValue.substr(0, 4) + '/' + inputValue.substr(4, 2) + '/' + inputValue.substr(6, 2);
        inputElement.value = formattedDate;
    }
}
