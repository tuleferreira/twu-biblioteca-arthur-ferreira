package com.twu.biblioteca.products;

import java.time.LocalDate;

public class Book extends Product {
    private final String author;
    private final LocalDate publishDate;

    public Book(int id, String title, String author, int yearPublished, int monthPublished, int dayPublished) {
        super(id, title, String.format("| %7s | %-70s| %-30s| %-10s |", "ID", "BOOK", "AUTHOR", "PUBLISHED"));
        this.author = author;
        this.publishDate = LocalDate.of(yearPublished, monthPublished, dayPublished);
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %02d/%02d/%s |", getId(), getTitle(), author, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear());
    }
}
