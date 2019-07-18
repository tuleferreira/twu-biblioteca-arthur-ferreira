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
}
