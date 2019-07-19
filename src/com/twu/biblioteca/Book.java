package com.twu.biblioteca;

import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private LocalDate publishDate;

    public Book(String name, String author, LocalDate publishDate) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
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

    @Override
    public String toString() {
        return String.format("| %-70s| %-30s| %02d/%02d/%s |", name, author, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear());

    }
}
