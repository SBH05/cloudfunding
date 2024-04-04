 // 제출하기 버튼 클릭 시 팝업 창 열기
 document.getElementById("submitButton").addEventListener("click", openPopup);

 // 팝업 열기 버튼 클릭 시 팝업 창 열기
 document.getElementById("openPopupButton").addEventListener("click", openPopup);

 // 팝업 창 닫기
 function closePopup() {
     document.getElementById("popup").style.display = "none";
 }

 // 팝업 창 열기
 function openPopup() {
     document.getElementById("popup").style.display = "block";
 }
