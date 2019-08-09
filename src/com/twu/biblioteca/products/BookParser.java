package com.twu.biblioteca.products;

import java.util.Arrays;

public class BookParser implements Parser<Product> {
    @Override
    public Book parse(String[] attributes) {
        Integer[] dateArr;

        dateArr = Arrays.stream(attributes[2].split("/"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        String title = attributes[0];
        String author = attributes[1];
        int day = dateArr[0];
        int month = dateArr[1];
        int year = dateArr[2];

        return new Book(title, author, year, month, day);
    }
}
