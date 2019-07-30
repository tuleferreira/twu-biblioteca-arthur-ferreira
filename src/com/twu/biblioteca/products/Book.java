package com.twu.biblioteca.products;

import java.time.LocalDate;

public class Book implements Product {
    private final int id;
    private final String title;
    private final String author;
    private final LocalDate publishDate;
    private final String productShowHeader;
    private boolean borrowed;
    private String borrowedBy;

    public Book(int id, String title, String author, int yearPublished, int monthPublished, int dayPublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishDate = LocalDate.of(yearPublished, monthPublished, dayPublished);
        this.productShowHeader = String.format("| %7s | %-70s| %-30s| %-10s |", "ID", "BOOK", "AUTHOR", "PUBLISHED");
        this.borrowed = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String getBorrowedBy() {
        return borrowedBy;
    }

    @Override
    public String getProductShowHeader() {
        return productShowHeader;
    }

    @Override
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public void setBorrowedBy(String libraryNumber) {
        this.borrowedBy = libraryNumber;
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %02d/%02d/%s |", id, title, author, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear());
    }
}
