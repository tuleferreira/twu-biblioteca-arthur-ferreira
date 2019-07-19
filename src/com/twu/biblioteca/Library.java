package com.twu.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> booksList = new ArrayList<>();

    public Library() {
        booksList.add(new Book("A Game of Thrones", "George R. R. Martin", LocalDate.of(1996, 8, 1)));
        booksList.add(new Book("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", LocalDate.of(2019, 8, 1)));
        booksList.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", LocalDate.of(1999, 7, 8)));
        booksList.add(new Book("Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", LocalDate.of(2019, 7, 16)));
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public String getBooks() {
        String allBooksString = String.format("| %-7s | %-70s| %-30s| %-19s | %-10s | %s |\n", "ID", "BOOK", "AUTHOR", "CATEGORY", "PUBLISHED", "RATING");

        for (Book book : booksList) {
            allBooksString += book.toString();
            allBooksString += "\n";
        }

        return allBooksString;
    }
}
