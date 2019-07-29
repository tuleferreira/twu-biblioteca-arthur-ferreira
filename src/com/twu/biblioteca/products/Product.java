package com.twu.biblioteca.products;

public interface Product {
    int getId();

    String getTitle();

    String getProductShowHeader();

    boolean isBorrowed();

    void setBorrowed(boolean borrowed);

    String toString();
}
