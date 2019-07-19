package com.twu.biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaApp {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";


    public static void main(String[] args) {
        Library mainLibrary = new Library();

        System.out.println(WELCOME_MESSAGE + "\n");

        startMenu(mainLibrary);
    }

    private static void startMenu(Library library) {
        System.out.println("Choose between those options:\n" +
                "1 - List of books.\n");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println(library.getBooks());
                break;
            default:
                System.out.println("Please select a valid option!");
                choice = scanner.nextInt();
        }
    }
}
