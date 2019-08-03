package com.twu.biblioteca.products;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUp() {
        testBook = new Book(1, "Test Title", "Test Author", 1992, 4, 13);
    }

    @Test
    public void checkProductHeader() {
        assertThat(testBook.getProductShowHeader(), is("|      ID | BOOK                                                                  | AUTHOR                        | PUBLISHED  |"));
    }

    @Test
    public void checkToString() {
        assertThat(testBook.toString(), is("|       1 | Test Title                                                            | Test Author                   | 13/04/1992 |"));
    }
}