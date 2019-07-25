package com.twu.biblioteca;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Library {
    private final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    private final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "Sorry, that book is not available";
    private final String SUCCESSFUL_RETURNING_MESSAGE = "Thank you for returning the book";
    private final String UNSUCCESSFUL_RETURNING_MESSAGE = "That is not a valid book to return.";
    private final List<Book> booksList = Arrays.asList(
            new Book(1, "A Game of Thrones", "George R. R. Martin", LocalDate.of(1996, 8, 1)),
            new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", LocalDate.of(2019, 8, 1)),
            new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", LocalDate.of(1999, 7, 8)),
            new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", LocalDate.of(2019, 7, 16)));


    public List<Book> getBooksList() {
        return booksList;
    }

    public Book getBook(int id) {
        for (Book book : booksList) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public Book getBook(String name) {
        for (Book book : booksList) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }

        return null;
    }

    public String checkoutBook(int id) {
        Book selectedBook = getBook(id);

        if (selectedBook == null || selectedBook.isBorrowed()) {
            return UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }

        selectedBook.setBorrowed(true);

        return SUCCESSFUL_CHECKOUT_MESSAGE;
    }

    public String checkoutBook(String name) {
        Book selectedBook = getBook(name);

        if (selectedBook == null || selectedBook.isBorrowed()) {
            return UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }

        selectedBook.setBorrowed(true);

        return SUCCESSFUL_CHECKOUT_MESSAGE;
    }

    public String returnBook(int id) {
        Book selectedBook = getBook(id);

        if (selectedBook == null || !selectedBook.isBorrowed()) {
            return UNSUCCESSFUL_RETURNING_MESSAGE;
        }

        selectedBook.setBorrowed(false);

        return SUCCESSFUL_RETURNING_MESSAGE;
    }

    public String returnBook(String name) {
        Book selectedBook = getBook(name);

        if (selectedBook == null || !selectedBook.isBorrowed()) {
            return UNSUCCESSFUL_RETURNING_MESSAGE;
        }

        selectedBook.setBorrowed(false);

        return SUCCESSFUL_RETURNING_MESSAGE;
    }

    @Override
    public String toString() {
        String allBooksString = String.format("| %7s | %-70s| %-30s| %-10s |\n", "ID", "BOOK", "AUTHOR", "PUBLISHED");

        for (int i = 0; i < booksList.size(); i++) {
            Book book = booksList.get(i);

            if (!book.isBorrowed()) {
                allBooksString += booksList.get(i).toString() + "\n";
            }
        }

        return allBooksString;
    }
}
