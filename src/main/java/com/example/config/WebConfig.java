package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("https://champions-frontend-9lpolspdm-sathyadharshinis-projects.vercel.app")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
}
