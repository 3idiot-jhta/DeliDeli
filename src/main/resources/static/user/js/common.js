// JWT 토큰을 쿠키에서 가져와 요청을 보내는 함수
async function fetchWithAuth(url, options = {}) {
    const token = getCookie('jwt');
    if (!token) {
        // 토큰이 없으면 로그인 페이지로 리다이렉트
        window.location.href = '/user/login';
        return;
    }
    if (!options.headers) {
        options.headers = {};
    }
    options.headers['Authorization'] = `Bearer ${token}`;
    return fetch(url, options);
}

// 쿠키에서 JWT 토큰을 가져오는 함수
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

// 사용자 정보 페이지 로드 시 사용자 정보를 가져오는 함수
async function loadUserInfo() {
    const response = await fetchWithAuth('/user/me');
    if (response.ok) {
        const data = await response.json();
        document.getElementById('userInfo').innerText = `환영합니다, ${data.username}님`;
    } else {
        alert('사용자 정보를 불러오지 못했습니다.');
        window.location.href = '/user/login';
    }
}

// 페이지가 로드되면 사용자 정보를 가져옴
window.onload = loadUserInfo;
