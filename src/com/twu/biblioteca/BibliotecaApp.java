package com.twu.biblioteca;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.sections.BooksSection;
import com.twu.biblioteca.sections.MoviesSection;
import com.twu.biblioteca.sections.Section;

import java.util.Scanner;

public class BibliotecaApp {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Section booksSection = new BooksSection("Book", "Library");
        Section moviesSection = new MoviesSection("Movie", "Movies Section");

        MainMenu mainMenu = new MainMenu();
        mainMenu.addSection(booksSection);
        mainMenu.addSection(moviesSection);

        System.out.println(WELCOME_MESSAGE + "\n");
        mainMenu.start(scanner);
    }
}
