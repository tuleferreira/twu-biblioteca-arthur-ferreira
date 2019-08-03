package com.twu.biblioteca.products;

public class Product {
    private final int id;
    private final String title;
    private final String productShowHeader;
    private String borrowedBy;

    public Product(int id, String title, String productShowHeader) {
        this.id = id;
        this.title = title;
        this.productShowHeader = productShowHeader;
        this.borrowedBy = null;
    }

    public boolean isBorrowed() {
        return borrowedBy != null;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getProductShowHeader() {
        return productShowHeader;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String libraryNumber) {
        this.borrowedBy = libraryNumber;
    }
}
