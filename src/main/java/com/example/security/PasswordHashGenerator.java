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
     *
     * @param rawPassword Plain text password
     * @return BCrypt hashed password
     */
    public static String generateHash(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * Verify if a raw password matches the hash
     *
     * @param rawPassword    Plain text password to verify
     * @param hashedPassword BCrypt hash from database
     * @return true if password matches
     */
    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }

}

