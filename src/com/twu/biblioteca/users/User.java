package com.twu.biblioteca.users;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class User {
    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private byte[] password;

    public User(String name, String email, String phone, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = hashPassword(password);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    private byte[] hashPassword(String password) {
        byte[] hashedPassword = new byte[0];
        KeySpec spec;
        SecretKeyFactory factory;

        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            spec = new PBEKeySpec(password.toCharArray(), new byte[]{1, 2, 3, 4}, 3000, 256);
            hashedPassword = factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }

    public boolean passwordMatches(String password) {
        return Arrays.equals(this.password, hashPassword(password));
    }

    @Override
    public String toString() {
        return String.format("LN - %s\nName: %s\nEmail: %s\nPhone: %s", libraryNumber, name, email, phone);
    }
}
