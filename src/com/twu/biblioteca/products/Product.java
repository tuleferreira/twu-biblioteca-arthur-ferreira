package com.twu.biblioteca.products;

import java.util.Optional;

public class Product {
    private int id;
    private final String title;
    private final String productShowHeader;
    private Optional<String> borrowedBy;

    public Product(String title, String productShowHeader, String borrowedBy) {
        this.title = title;
        this.productShowHeader = productShowHeader;
        this.borrowedBy = Optional.ofNullable(borrowedBy);
    }

    public Product(String title, String productShowHeader) {
        this(title, productShowHeader, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBorrowed() {
        return borrowedBy.isPresent();
    }

    public String getTitle() {
        return title;
    }

    public String getProductShowHeader() {
        return productShowHeader;
    }

    public Optional<String> getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String libraryNumber) {
        this.borrowedBy = Optional.ofNullable(libraryNumber);
    }

    @Override
    public String toString() {
        return title;
    }
}
