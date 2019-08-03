package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.products.Book;
import com.twu.biblioteca.products.Movie;
import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.LoginManager;
import com.twu.biblioteca.users.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

public class BibliotecaApp {
    private LoginManager loginManager;
    private Scanner scanner;

    private BibliotecaApp(LoginManager loginManager, Scanner scanner) {
        this.loginManager = loginManager;
        this.scanner = scanner;
    }

    private void start() {
        Optional<User> loggedInUser;

        String libraryNumberInput;
        String passwordInput;

        do {
            System.out.println("Library Number:");
            libraryNumberInput = scanner.nextLine();

            System.out.println("Password:");
            passwordInput = scanner.nextLine();

            loggedInUser = login(libraryNumberInput, passwordInput);
        } while (!loggedInUser.isPresent());

        MainMenu mainMenu = new MainMenu(loggedInUser.get());

        mainMenu.addSection(new Section("Book", "Library", Arrays.asList(
                new Book(1, "A Game of Thrones", "George R. R. Martin", 1992, 8, 1),
                new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", 2019, 8, 1),
                new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 7, 8),
                new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", 2019, 7, 16)
        )));
        mainMenu.addSection(new Section("Movie", "Movies Section", Arrays.asList(
                new Movie(1, "The Godfather", 1972, "Francis Ford Coppola", 10),
                new Movie(2, "The Dark Knight", 2008, "Christopher Nolan", 9),
                new Movie(3, "Casablanca", 1942, "Michael Curtiz", 9),
                new Movie(4, "Schindler's List", 1993, "Steven Spielberg")
        )));

        mainMenu.start(scanner);
    }

    private Optional<User> login(String libraryNumber, String password) {
        Optional<User> user = loginManager.identifyUserByLibraryNumber(libraryNumber);

        if (!user.isPresent()) {
            System.out.println("Please enter a valid library number.\n");
        } else if (user.get().passwordMatches(password)) {
            return user;
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager(Collections.singletonList(
                new User("Arthur", "test@twu.com", "(51) 11111-2222", "123-4567", "pass123")
        ));

        Scanner scanner = new Scanner(System.in);

        new BibliotecaApp(loginManager, scanner).start();
    }
}