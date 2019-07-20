package com.twu.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private final List<Book> booksList = Arrays.asList(new Book("A Game of Thrones", "George R. R. Martin", LocalDate.of(1996, 8, 1)),
            new Book("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", LocalDate.of(2019, 8, 1)),
            new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", LocalDate.of(1999, 7, 8)),
            new Book("Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", LocalDate.of(2019, 7, 16)));


    public List<Book> getBooksList() {
        return booksList;
    }

    @Override
    public String toString() {
        String allBooksString = String.format("| %-70s| %-30s| %-10s |\n", "BOOK", "AUTHOR", "PUBLISHED");

        for (Book book : booksList) {
            allBooksString += book.toString();
            allBooksString += "\n";
        }

        return allBooksString;
    }
}
