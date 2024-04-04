
// 상단 슬라이더
document.addEventListener('DOMContentLoaded', function () {
    const slider = document.querySelector('.slider');
    const prevButton = document.querySelector('.prev');
    const nextButton = document.querySelector('.next');
    let currentIndex = 0;

    function showImage(index) {
        const slideWidth = slider.clientWidth / 6; // 5은 이미지 개수
        slider.style.transform = `translateX(-${index * slideWidth}px)`;
    }

    prevButton.addEventListener('click', function () {
        currentIndex = (currentIndex - 1 + 6) % 6;
        showImage(currentIndex);
    });

    nextButton.addEventListener('click', function () {
        currentIndex = (currentIndex + 1) % 6;
        showImage(currentIndex);
    });
});

// // 신규펀딩 아이콘
// const productIcons = [
//     { icon: "./00_img/유기농 현미 누룽지 포켓스낵으로, 간편한 한 끼부터 아이들 간식까지 해결.png", text: "유기농 현미 누룽지 포켓스낵" },
//     { icon: "./00_img/임금님께 진상하던 쌀로 빚은 프리미엄 막걸리 '백년향'.png", text: "프리미엄 막걸리 '백년향'" },
//     { icon: "./00_img/자두의 무한 변신!! 철없는 자두떡! 철없는 자두청!.png", text: "철없는 자두떡! 철없는 자두청!" },
//     { icon: "./00_img/클라우드 푸딩 최초, 최대 사이즈] 팔뚝만한 왕특대 킹타이거새우를 소개합니다!.png", text: "건강한 두부밥" },
//     { icon: "./00_img/지금까지 함박은 잊으라! 3.5cm두께 프랑스식 진짜 함박스테이크.png", text: "프랑스식 진짜 함박스테이크" },
//     { icon: "./00_img/[스위스직수입한정판] 오리지널 퐁듀치즈의 압도적 풍미 <퐁듀스페셜에디션>.png", text: "<퐁듀스페셜에디션>" },
// ];
//
// function updateProductIcons() {
//     const iconList = document.querySelector('.square-icons');
//     iconList.innerHTML = '';
//
//     for (let i = 0; i < 2; i++) {
//         const row = document.createElement('div');
//         row.classList.add('icon-row');
//
//         for (let j = 0; j < 3; j++) {
//             const iconItem = document.createElement('div');
//             iconItem.classList.add('new-icon-item');
//
//             const index = i * 3 + j;
//             if (index < productIcons.length) {
//                 iconItem.innerHTML = `
//                                 <img src="${productIcons[index].icon}" alt="${productIcons[index].text}"><br>
//                                 <span>${productIcons[index].text}</span>
//                             `;
//             }
//
//             row.appendChild(iconItem);
//         }
//
//         iconList.appendChild(row);
//     }
// }
// updateProductIcons();


