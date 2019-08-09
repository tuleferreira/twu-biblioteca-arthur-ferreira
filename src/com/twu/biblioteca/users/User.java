package com.twu.biblioteca.users;

public class User {
    private String name;
    private String email;
    private String phone;
    private String libraryNumber;
    private String password;

    public User(String name, String email, String phone, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "LN - " + libraryNumber + "\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone;
    }
}
