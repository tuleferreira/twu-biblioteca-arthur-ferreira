package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.sections.BooksSection;
import com.twu.biblioteca.sections.MoviesSection;
import com.twu.biblioteca.users.Users;

import java.util.Scanner;

public class BibliotecaApp {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    public static String libraryNumberConnected;
    public static Users users = new Users();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String libraryNumberInput;
        String passwordInput;
        boolean connected;

        do {
            System.out.println("Library Number:");
            libraryNumberInput = scanner.nextLine();

            System.out.println("Password:");
            passwordInput = scanner.nextLine();

            connected = users.login(libraryNumberInput, passwordInput);
        } while (!connected);

        libraryNumberConnected = libraryNumberInput;


        MainMenu mainMenu = new MainMenu();
        mainMenu.addSection(new BooksSection("Book", "Library"));
        mainMenu.addSection(new MoviesSection("Movie", "Movies Section"));


        System.out.println("\n" + WELCOME_MESSAGE + "\n");
        mainMenu.start(scanner);
    }
}
