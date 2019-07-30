package com.twu.biblioteca.products;

public interface Product {
    int getId();

    String getTitle();

    String getProductShowHeader();

    boolean isBorrowed();

    String getBorrowedBy();

    void setBorrowed(boolean borrowed);

    void setBorrowedBy(String libraryNumber);

    String toString();
}
