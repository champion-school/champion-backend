package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class to generate BCrypt hashes for passwords
 * Use this to generate hashes before inserting into database
 */
public class PasswordHashGenerator {
    
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    /**
     * Generate a BCrypt hash for a password
     * @param rawPassword Plain text password
     * @return BCrypt hashed password
     */
    public static String generateHash(String rawPassword) {
        return encoder.encode(rawPassword);
    }
    
    /**
     * Verify if a raw password matches the hash
     * @param rawPassword Plain text password to verify
     * @param hashedPassword BCrypt hash from database
     * @return true if password matches
     */
    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
    
    public static void main(String[] args) {
        // Simple test: Generate hash for "12345"
        String password = "12345";
        String hash = generateHash(password);
        
        System.out.println("Password: " + password);
        System.out.println("BCrypt Hash: " + hash);
        System.out.println("Verification: " + verifyPassword(password, hash));
        
        // You can use this hash in SQL:
        // UPDATE admin SET password = '[hash_here]' WHERE email = '...';
    }
}

