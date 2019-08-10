package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.products.BookParser;
import com.twu.biblioteca.products.MovieParser;
import com.twu.biblioteca.products.Parser;
import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.LoginManager;
import com.twu.biblioteca.users.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.twu.biblioteca.menus.Menu.SCANNER;

public class BibliotecaApp {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    private MainMenu mainMenu;
    private LoginManager loginManager;

    private BibliotecaApp(LoginManager loginManager) {
        this.loginManager = loginManager;
        mainMenu = MainMenu.getInstance();
    }

    private void start() throws IOException {
        Optional<User> loggedInUser;
        String libraryNumberInput;
        String passwordInput;

        System.out.println(String.format("%s\n", WELCOME_MESSAGE));

        do {
            System.out.println("Library Number:");
            libraryNumberInput = SCANNER.nextLine();

            System.out.println("Password:");
            passwordInput = SCANNER.nextLine();

            loggedInUser = login(libraryNumberInput, passwordInput);
        } while (!loggedInUser.isPresent());

        mainMenu.setLoggedInUser(loggedInUser.get());
        mainMenu.addSection(new Section("Book", "Library", parseTxt("./src/books.csv", new BookParser())));
        mainMenu.addSection(new Section("Movie", "Movies Section", parseTxt("./src/movies.csv", new MovieParser())));
        mainMenu.start();
    }

    private Optional<User> login(String libraryNumber, String password) {
        Optional<User> user = loginManager.identifyUserByLibraryNumber(libraryNumber);

        if (!user.isPresent()) {
            System.out.println("Please enter a valid library number.\n");
        } else if (!user.get().passwordMatches(password)) {
            System.out.println("Incorrect password.\n");
            return Optional.empty();
        }

        return user;
    }

    private <T> List<T> parseTxt(String pathname, Parser<T> parser) throws IOException {
        File file = new File(pathname);

        return Files.lines(Paths.get(file.getAbsolutePath()))
                .map(line -> line.split(";"))
                .map(parser::parse)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        LoginManager loginManager = new LoginManager(Collections.singletonList(
                new User("Arthur", "test@twu.com", "(51) 11111-2222", "123-4567", "pass123")
        ));

        new BibliotecaApp(loginManager).start();
    }
}