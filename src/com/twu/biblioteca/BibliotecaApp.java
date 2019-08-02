package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.sections.BooksSection;
import com.twu.biblioteca.sections.MoviesSection;
import com.twu.biblioteca.users.LoginManager;
import com.twu.biblioteca.users.User;

import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;

public class BibliotecaApp {
    //  TODO: Move Welcome Message display to Main Menu
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    // TODO: Replace "global" variable by logged in user instance
    public static String libraryNumberConnected;

    private LoginManager loginManager;
    private Scanner scanner;

    public BibliotecaApp(LoginManager loginManager, Scanner scanner) {
        this.loginManager = loginManager;
        this.scanner = scanner;
    }

    public void start() {
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

        libraryNumberConnected = libraryNumberInput;

        MainMenu mainMenu = new MainMenu(loginManager.identifyUserByLibraryNumber(libraryNumberInput).get());
        mainMenu.addSection(new BooksSection("Book", "Library"));
        mainMenu.addSection(new MoviesSection("Movie", "Movies Section"));

        System.out.println("\n" + WELCOME_MESSAGE + "\n");
        mainMenu.start(scanner);
    }

    // TODO: Return Optional<User> instead of boolean so that it can be passed around the application
    private boolean login(String libraryNumber, String password) {
        Optional<User> user = loginManager.identifyUserByLibraryNumber(libraryNumber);

        if (!user.isPresent()) {
            System.out.println("Please enter a valid library number.");
            return false;
        }

        return user.get().loginAuthentication(password);
    }

    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager(Collections.singletonList(
            new User("Arthur", "test@twu.com", "(51) 11111-2222", "472-6231", "pass123")
        ));

        Scanner scanner = new Scanner(System.in);

        new BibliotecaApp(loginManager, scanner).start();
    }
}
