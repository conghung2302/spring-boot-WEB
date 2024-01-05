// package com.example.config;
// import org.springframework.boot.web.server.WebServerFactoryCustomizer;
// import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.web.servlet.config.annotation.*;

// @Configuration
// @EnableWebMvc
// @ComponentScan
// public class WebConfig implements WebMvcConfigurer {


//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/").permitAll() // Cho phép truy cập vào URL gốc mà không cần xác thực
//                 .antMatchers("/login").permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .defaultSuccessUrl("/dashboard")
//                 .permitAll()
//                 .and()
//             .logout()
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login")
//                 .permitAll();
//     }
// }