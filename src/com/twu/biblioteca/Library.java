package com.twu.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private final List<Book> booksList = Arrays.asList(
            new Book(1, "A Game of Thrones", "George R. R. Martin", LocalDate.of(1996, 8, 1)),
            new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", LocalDate.of(2019, 8, 1)),
            new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", LocalDate.of(1999, 7, 8)),
            new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", LocalDate.of(2019, 7, 16)));


    public List<Book> getBooksList() {
        return booksList;
    }

    public Book getBookById(int id) {
        for (Book book : booksList) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public String checkoutBook(int id) {
        Book selectedBook = getBookById(id);

        if (selectedBook != null) {
            selectedBook.setBorrowed(true);
        }

        return "Thank you! Enjoy the book";
    }

    @Override
    public String toString() {
        String allBooksString = String.format("| %7s | %-70s| %-30s| %-10s |\n", "ID", "BOOK", "AUTHOR", "PUBLISHED");

        for (int i = 0; i < booksList.size(); i++) {
            Book book = booksList.get(i);

            if (!book.isBorrowed()) {
                allBooksString += new StringBuilder(booksList.get(i).toString()).append("\n").toString();
            }
        }

        return allBooksString;
    }
}
