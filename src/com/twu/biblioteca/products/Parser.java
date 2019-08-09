package com.twu.biblioteca.products;

public interface Parser<Product> {
    Product parse(String[] line);
}
