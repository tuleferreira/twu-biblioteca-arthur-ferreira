package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> booksList = new ArrayList<>();

    public Library() {
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void addBookToList(Book book) {
        booksList.add(book);
    }

    public String showBooks() {
        String allBooksString = String.format("| %-7s | %-70s| %-30s| %-19s | %-10s | %s |\n", "ID", "BOOK", "AUTHOR", "CATEGORY", "PUBLISHED", "RATING");

        for (Book book : booksList) {
            allBooksString += book.toString();
            allBooksString += "\n";
        }

        return allBooksString;
    }
}
