package com.twu.biblioteca.products;

import java.time.LocalDate;

public class Book extends Product {
    private final String author;
    private final LocalDate publishDate;

    public Book(String title, String author, int year, int month, int day) {
        super(title, String.format("| %7s | %-70s| %-30s| %-10s |", "ID", "BOOK", "AUTHOR", "PUBLISHED"));
        this.author = author;

        this.publishDate = LocalDate.of(year, month, day);
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %02d/%02d/%s |", getId(), getTitle(), author, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear());
    }
}
