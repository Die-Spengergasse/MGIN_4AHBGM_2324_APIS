/**
 * Created: 2022-12-10
 * Author: Rudolf Radlbauer
 */
package at.spengergasse.med_px.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * configure authorization of routes
 * basicly there are the following rules:
 *      / and /public may be accessed by all users
 *      /admin/** and /api/admin/** may be accessed by admin users
 *      /doctor/** and /api/doctor/** may be accessed by doctors
 *      all other resources may be accessed by authenticated users
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // https://stackoverflow.com/questions/33699724/405-method-not-allowed-for-post
                // https://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#csrf-configure
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests((requests) -> requests
                        // remove the following line for production mode
                                .anyRequest().permitAll()
                        // uncomment the following line for access controll
//                        .requestMatchers("/").permitAll()                   // start page
//                        .requestMatchers("/public/**").permitAll()          // public pages
//                        .requestMatchers("/pub/**").permitAll()          // public pages
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/doctor/**").hasRole("DOCTOR")
//                        .requestMatchers("/api/doctor/**").hasRole("DOCTOR")
//                        .anyRequest().authenticated()
                )
                // route for login form
                .formLogin((form) -> form
                        .loginPage("/pub/login")
                        .permitAll()
                )
                // logout will redirect to welcome page
                .logout((logout) -> logout.permitAll()
                        .logoutSuccessUrl("/pub/welcome"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
