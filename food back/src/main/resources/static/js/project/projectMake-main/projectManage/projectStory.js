// 입력창에 입력이 발생할 때 남은 글자 수 계산

function updateCharacterCount() {
    var inputElement = document.getElementById('project-summary-text');
    var characterCountElement = document.getElementById('characterCount');

    var remainingCharacters = 100 - inputElement.value.length;
    characterCountElement.textContent = remainingCharacters + '자 남음';
}
