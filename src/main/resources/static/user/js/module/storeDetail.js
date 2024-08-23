window.onload = function () {
    // 메뉴 그룹 클릭 이벤트 처리
    const menuGroups = document.querySelectorAll(".sdTabCnt__menu-gItem > h3");

    menuGroups.forEach(function (group) {
        group.addEventListener("click", function () {
            // 해당 그룹 내의 모든 .sdTabCnt__menu-item 요소 선택
            const menuItems = group.parentNode.querySelectorAll(".sdTabCnt__menu-item");

            // 첫 번째 항목의 현재 display 상태를 확인
            const currentDisplay = window.getComputedStyle(menuItems[0]).display;

            // 각 항목의 display 속성을 토글
            menuItems.forEach(function (item) {
                if (currentDisplay === "none") {
                    item.style.display = "grid";
                } else {
                    item.style.display = "none";
                }
            });
        });
    });

    // 메뉴 항목 클릭 이벤트 처리
    const menuItems = document.querySelectorAll(".sdTabCnt__menu-item");

    menuItems.forEach(function (item) {
        item.addEventListener("click", function () {
            const menuKey = item.getAttribute("data-menu-key");
            openMenuDetail(menuKey);
        });
    });

    // 찜하기 및 취소 이벤트 처리
    const wishlistBtn = document.getElementById("wishlist-btn");
    if (wishlistBtn) {
        wishlistBtn.addEventListener("click", function () {
            const storeInfoKey = wishlistBtn.getAttribute("data-store-info-key");
            toggleLike(storeInfoKey);
        });
    }
};

// 모달창 생성 및 사이즈 설정
function openMenuDetail(menuKey) {
    const url = '/user/menuDetail/' + menuKey;
    window.open(url, 'menuDetailWindow', 'width=720,height=720');
}

// 찜하기 및 취소 기능
function toggleLike(storeInfoKey) {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/user/toggleLike", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onload = function () {
        if (xhr.status === 200) {
            const response = xhr.responseText;
            if (response === "not_logged_in") {
                alert("로그인이 필요합니다.");
            } else {
                // 버튼 텍스트를 토글합니다.
                const button = document.getElementById("wishlist-btn");
                button.textContent = button.textContent === "찜하기" ? "찜 취소" : "찜하기";
            }
        }
    };
    xhr.send("storeInfoKey=" + storeInfoKey);
}
