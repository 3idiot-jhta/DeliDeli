<<<<<<< HEAD
/*
=======
>>>>>>> 6790271a9e6cc9fd013d5711ab9876fc41f2d979
package kr.co.jhta.app.delideli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
<<<<<<< HEAD
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
*/

/*
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index", "/user/notice", "/user/detail").permitAll()  //모두 접근 가능
                        .anyRequest().authenticated()  //그외 요청은 인증받은 사람만 접근 가능
=======
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/index.html", "/resources/**").permitAll() // index.html 및 리소스 접근 허용
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .permitAll()
>>>>>>> 6790271a9e6cc9fd013d5711ab9876fc41f2d979
                );

        return http.build();
    }
}
<<<<<<< HEAD
*/
=======
>>>>>>> 6790271a9e6cc9fd013d5711ab9876fc41f2d979
