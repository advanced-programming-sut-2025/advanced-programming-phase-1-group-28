package com.example.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAlghorithm {
    public static String DecryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Use SHA-256
            byte[] hashBytes = md.digest(password.getBytes());

            // Convert bytes to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (
                NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 Algorithm not found", e);
        }
    }
}
