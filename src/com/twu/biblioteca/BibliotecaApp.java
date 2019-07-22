package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    public static void main(String[] args) {
        Library mainLibrary = new Library();

        System.out.println(WELCOME_MESSAGE + "\n");

        Menu mainMenu = new Menu();

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println(mainMenu);

            choice = mainMenu.getOption(scanner.nextInt());

            switch (choice) {
                case "List of books":
                    System.out.println(mainLibrary.toString());
                    System.out.println("Enter the ID of the book you want:");
                    System.out.println(mainLibrary.checkoutBook(scanner.nextInt()) + "\n");
                    break;
                case "Quit":
                    break;
                default:
                    System.out.println(choice);
            }
        } while (!choice.equals("Quit"));
    }
}
