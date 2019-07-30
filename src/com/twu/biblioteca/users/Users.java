package com.twu.biblioteca.users;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> userList;

    public Users() {
        userList = new ArrayList<>();

        User user = new User("Arthur", "test@twu.com", "472-6231", "pass123");
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
}
