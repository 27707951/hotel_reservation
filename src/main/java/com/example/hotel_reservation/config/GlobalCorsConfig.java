package com.example.hotel_reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 匹配所有端點
                        .allowedOrigins("http://localhost:63342") // 允許的前端來源
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 支援的 HTTP 方法
                        .allowedHeaders("*") // 允許的請求 Header
                        .allowCredentials(true); // 允許 Cookies 和認證資訊
            }
        };
    }
}
