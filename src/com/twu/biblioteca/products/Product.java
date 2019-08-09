package com.twu.biblioteca.products;

public class Product {
    private int id;
    private final String title;
    private final String productShowHeader;
    private String borrowedBy;

    public Product(String title, String productShowHeader) {
        this.title = title;
        this.productShowHeader = productShowHeader;
        this.borrowedBy = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBorrowed() {
        return borrowedBy != null;
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
