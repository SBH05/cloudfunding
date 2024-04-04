// 판매자 명 : 입력창에 입력이 발생할 때 남은 글자 수 계산
function updateCharacterCount() {
    var inputElement = document.getElementById('seller-name-text');
    var characterCountElement = document.getElementById('characterCount');

    var remainingCharacters = 30 - inputElement.value.length;
    characterCountElement.textContent = remainingCharacters + '자 남음';
}

// 이메일 주소 선택
function updateEmailDomain() {
    var emailInput = document.getElementById("email");
    var siteSelect = document.getElementById("site");
    var selectedSite = siteSelect.value;

    // 선택된 사이트에 대한 도메인 추가
    var domain = "";
    switch (selectedSite) {
        case "site1":
            domain = "gmail.com";
            break;
        case "site2":
            domain = "naver.com";
            break;
        case "site3":
            domain = "daum.net";
            break;
        case "site4":
            domain = "yahoo.com"; 
            break;
        default:
            domain = "";
    }

    // 이메일 주소에 선택된 사이트의 도메인을 추가
    emailInput.value = emailInput.value.split('@')[0] + '@' + domain;
}