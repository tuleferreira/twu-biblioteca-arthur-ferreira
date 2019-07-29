package com.twu.biblioteca.sections;

import com.twu.biblioteca.products.Book;

import java.util.Arrays;

public class BooksSection extends Section {
    public BooksSection(String productName, String sectionName) {
        super(productName, sectionName);

        setProductsList(Arrays.asList(
                new Book(1, "A Game of Thrones", "George R. R. Martin", 1992, 8, 1),
                new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", 2019, 8, 1),
                new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 7, 8),
                new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", 2019, 7, 16)));
    }
}
