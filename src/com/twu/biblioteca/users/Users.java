package com.twu.biblioteca.users;

import com.twu.biblioteca.BibliotecaApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    private List<User> userList;

    public Users() {
        userList = new ArrayList<>();

        User user = new User("Arthur", "test@twu.com", "(51) 11111-2222", "472-6231", "pass123");
        userList.add(user);
    }

    public User getUser(String libraryNumber) {
        for (User user : userList) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }

        return null;
    }

    public boolean login(String libraryNumber, String password) {
        User user = getUser(libraryNumber);

        if (user != null) {
            return user.loginAuthentication(password);
        }

        System.out.println("Please enter a valid library number.");
        return false;
    }

    public void startLogin(Scanner scanner) {
        String libraryNumberInput;
        String passwordInput;
        boolean connected;

        do {
            System.out.println("Library Number:");
            libraryNumberInput = scanner.nextLine();

            System.out.println("Password:");
            passwordInput = scanner.nextLine();

            connected = login(libraryNumberInput, passwordInput);
        } while (!connected);

        BibliotecaApp.libraryNumberConnected = libraryNumberInput;
    }
}
