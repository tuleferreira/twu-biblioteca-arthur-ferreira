package com.twu.biblioteca.users;

public class User {
    private String name;
    private String email;
    private String libraryNumber;
    private String password;

    public User(String name, String email, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean loginAuthentication(String password) {
        boolean passwordCheck = this.password.equals(password);

        if (!passwordCheck) {
            System.out.println("Incorrect password.");
            return false;
        }


        return true;
    }
}
