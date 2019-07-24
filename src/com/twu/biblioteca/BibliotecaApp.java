package com.twu.biblioteca;

import javafx.util.converter.NumberStringConverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    public static void main(String[] args) {
        Library mainLibrary = new Library();

        System.out.println(WELCOME_MESSAGE + "\n");

        Menu mainMenu = new Menu();

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        String bookSelected;

        do {
            System.out.println(mainMenu);

            try {
                choice = mainMenu.getOption(Integer.valueOf(scanner.nextLine()));

                switch (choice) {
                    case "List of books":
                        System.out.println(mainLibrary.toString());
                        System.out.println("Enter the ID or Name of the book you want:");

                        bookSelected = scanner.nextLine();

                        try {
                            System.out.println(mainLibrary.checkoutBook(Integer.valueOf(bookSelected)) + "\n");
                        } catch (NumberFormatException e) {
                            System.out.println(mainLibrary.checkoutBook(bookSelected) + "\n");
                        }

                        break;
                    case "Returning a book":
                        System.out.println("Enter the ID or Name of the book you want to return:");

                        bookSelected = scanner.nextLine();

                        try {
                            System.out.println(mainLibrary.returnBook(Integer.valueOf(bookSelected)) + "\n");
                        } catch (NumberFormatException e) {
                            System.out.println(mainLibrary.returnBook(bookSelected) + "\n");
                        }

                        break;
                    case "Quit":
                        break;
                    default:
                        System.out.println(choice);
                }
            } catch (NumberFormatException e) {
                System.out.println(mainMenu.INVALID_OPTION + "\n");
            }
        } while (!choice.equals("Quit"));
    }
}
