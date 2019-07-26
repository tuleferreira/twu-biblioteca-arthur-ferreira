package com.twu.biblioteca;

import java.time.LocalDate;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final LocalDate publishDate;
    private boolean borrowed;

    public Book(int id, String name, String author, LocalDate publishDate) {
        this.id = id;
        this.title = name;
        this.author = author;
        this.publishDate = publishDate;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %02d/%02d/%s |", id, title, author, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear());
    }
}
