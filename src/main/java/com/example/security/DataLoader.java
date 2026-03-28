package com.example.security;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import com.example.security.PasswordHashGenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Value("${admin.email}")
    private String email;

    @Value("${admin.password}")
    private String password;

    @Bean
    CommandLineRunner init(AdminRepository adminRepository) {
        return args -> {

            if (email == null || password == null) {
                System.out.println(" Admin credentials not set");
                return;
            }

            if (adminRepository.findByEmail(email).isPresent()) {
                System.out.println("Admin already exists");
                return;
            }

            Admin admin = new Admin();
            admin.setEmail(email);
            admin.setPassword(PasswordHashGenerator.generateHash(password));

            adminRepository.save(admin);

            System.out.println(" Admin created successfully!");
        };
    }
}