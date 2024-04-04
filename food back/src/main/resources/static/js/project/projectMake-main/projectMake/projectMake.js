// 카테고리 선택 토글
function toggleMenu() {
    var menuBar = document.getElementById("menuBar");
    menuBar.classList.toggle("active");
}

function changeMenu(item) {
    var menuBar = document.getElementById("menuBar");
    var toggleButton = document.querySelector(".toggle-button");

    var menuItems = menuBar.getElementsByTagName("a");

    for (var i = 0; i < menuItems.length; i++) {
        menuItems[i].classList.remove("active-item");
    }

    item.classList.add("active-item");

    // preventDefault()를 사용하여 기본 동작 막기
    event.preventDefault();

    item.classList.add("active-item");
    toggleMenu(); // 선택된 항목을 클릭하면 메뉴를 다시 접도록 설정
    toggleButton.innerText = item.innerText; // 토글 버튼의 텍스트 변경
}