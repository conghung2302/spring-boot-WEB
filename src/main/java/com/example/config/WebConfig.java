//package com.example.config;
//import org.springframework.boot.web.server.WebServerFactoryCustomizer;
//import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan
//public class WebConfig implements WebMvcConfigurer {
//
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**", "/js/**", "/fonts/**", "/sass/**", "/img/**")
//                .addResourceLocations("classpath:/static/css/", "classpath:/static/js/", "classpath:/static/fonts/","classpath:/static/sass/",
//                        "classpath:/static/img/");
//    }
//
//    @Bean
//    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
//        return (factory) -> factory.setRegisterDefaultServlet(true);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//}