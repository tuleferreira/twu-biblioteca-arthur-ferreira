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
    public void checkProperties() {
        assertThat(1, is(testBook.getId()));
        assertThat("Test Title", is(testBook.getTitle()));
        assertThat("Test Author", is(testBook.getAuthor()));
        assertThat(13, is(testBook.getPublishDate().getDayOfMonth()));
        assertThat(04, is(testBook.getPublishDate().getMonthValue()));
        assertThat(1992, is(testBook.getPublishDate().getYear()));
        assertFalse(testBook.isBorrowed());
        assertNull(testBook.getBorrowedBy());
    }

    @Test
    public void setBorrowed() {
        testBook.setBorrowed(true);
        assertTrue(testBook.isBorrowed());
    }

    @Test
    public void setBorrowedBy() {
        testBook.setBorrowedBy("123-4567");
        assertThat("123-4567", is(testBook.getBorrowedBy()));
    }

    @Test
    public void formatProductShowHeader() {
        assertThat("|      ID | BOOK                                                                  | AUTHOR                        | PUBLISHED  |", is(testBook.getProductShowHeader()));
    }

    @Test
    public void toStringTest() {
        assertThat("|       1 | Test Title                                                            | Test Author                   | 13/04/1992 |", is(testBook.toString()));
    }
}