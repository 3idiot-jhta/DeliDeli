package kr.co.jhta.app.delideli.admin.control;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jhta.app.delideli.common.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private static final String ADMIN_ID = "admin";
    private static final String ADMIN_PW = "123";

    private final JwtTokenProvider jwtTokenProvider;

    // 로그인 페이지
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        return "admin/adminLogin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        HttpServletResponse response,
                        Model model) {
        if (ADMIN_ID.equals(username) && ADMIN_PW.equals(password)) {
            // 인증 성공 시 JWT 토큰 생성
            String token = jwtTokenProvider.generateToken(username, "ROLE_ADMIN", 604800000L);
            Cookie cookie = jwtTokenProvider.createCookie(token);
            response.addCookie(cookie);

            // 세션에 admin 속성 추가
            session.setAttribute("admin", true);
            return "redirect:/admin/adminMain";
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "admin/adminLogin";
        }
    }

    @GetMapping("/adminMain")
    public String showMainPage(HttpSession session, Model model) {
        if (session.getAttribute("admin") != null) {
            return "admin/adminMain";
        } else {
            model.addAttribute("errorMessage", "로그인이 필요합니다.");
            return "admin/adminLogin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        SecurityContextHolder.clearContext();

        Cookie cookie = new Cookie("JWT", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        session.invalidate();
        return "redirect:/admin/login";
    }
}
