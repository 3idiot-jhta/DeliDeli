document.addEventListener('DOMContentLoaded', function() {
    var menuItems = document.querySelectorAll('.aside__nav--depth1 > li > a');

    menuItems.forEach(function(menuItem) {
        menuItem.addEventListener('click', function(event) {
            var subMenu = this.nextElementSibling;
            if (subMenu && subMenu.classList.contains('aside__nav--depth2')) {
                event.preventDefault(); // 기본 링크 이동을 막습니다.

                // 하위 메뉴 열기/닫기
                subMenu.classList.toggle('open');

                // 일정 시간 후에 페이지 이동
                setTimeout(() => {
                    window.location.href = this.href;
                }, 300); // 300ms 후에 페이지 이동, 원하는 시간으로 조절 가능
            }
        });
    });
});
