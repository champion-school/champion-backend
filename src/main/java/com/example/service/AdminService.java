package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Admin login(String email, String password) {

        Admin admin = adminRepository.findByEmail(email).orElse(null);

        if (admin == null) {
            return null;
        }

        // ✅ SECURE: BCrypt password verification
        if (!passwordEncoder.matches(password, admin.getPassword())) {
            return null;
        }

        return admin;
    }
}