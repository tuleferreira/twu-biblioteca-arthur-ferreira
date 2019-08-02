package com.twu.biblioteca.users;

import java.util.List;
import java.util.Optional;

public class LoginManager {

    private final List<User> users;

    public LoginManager(List<User> users) {
        this.users = users;
    }

    public Optional<User> identifyUserByLibraryNumber(String libraryNumber) {
        return users.stream()
            .filter(user -> user.getLibraryNumber().equals(libraryNumber))
            .findFirst();
    }
}
