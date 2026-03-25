package com.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Quick hash generator for passwords
 * Run this to generate BCrypt hashes for your admin passwords
 */
public class GenerateAdminHash {
    
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // Generate hashes for common passwords
        String[] passwords = {"12345", "admin123", "password123", "school123"};
        
        System.out.println("=====================================");
        System.out.println("BCrypt Password Hashes - Use in Database");
        System.out.println("=====================================\n");
        
        for (String password : passwords) {
            String hash = encoder.encode(password);
            System.out.println("Password: " + password);
            System.out.println("Hash:     " + hash);
            System.out.println();
        }
        
        // Test verification
        System.out.println("=====================================");
        System.out.println("Verification Test");
        System.out.println("=====================================\n");
        
        String testHash = encoder.encode("12345");
        System.out.println("Hash: " + testHash);
        System.out.println("Verify '12345': " + encoder.matches("12345", testHash));
        System.out.println("Verify 'wrong':  " + encoder.matches("wrong", testHash));
    }
}

