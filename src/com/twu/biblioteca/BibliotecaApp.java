package com.twu.biblioteca;

public class BibliotecaApp {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    public static void main(String[] args) {
        Library mainLibrary = new Library();

        System.out.println(WELCOME_MESSAGE + "\n");

        Menu mainMenu = new Menu();
        mainMenu.start(mainLibrary);
    }
}
