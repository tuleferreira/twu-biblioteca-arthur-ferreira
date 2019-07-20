package com.twu.biblioteca;

import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaApp {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    public static void main(String[] args) {
        Library mainLibrary = new Library();

        System.out.println(WELCOME_MESSAGE + "\n");

        Menu mainMenu = new Menu();

        System.out.println(mainMenu);

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            choice = mainMenu.getOption(scanner.nextInt());

            switch (choice) {
                case "List of books":
                    System.out.println(mainLibrary.toString());
                    break;
                case "Quit":
                    break;
                default:
                    System.out.println(choice);
            }
        } while (!choice.equals("Quit"));
    }
}
