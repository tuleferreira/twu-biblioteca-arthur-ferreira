package com.twu.biblioteca;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private LocalDate publishDate;
    private boolean borrowed;

    public Book(int id, String name, String author, LocalDate publishDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %02d/%02d/%s |", id, name, author, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear());
    }
}
