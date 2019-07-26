package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUp() {
        testBook = new Book(1, "Test Title", "Test Author", LocalDate.of(1992, 4, 13));
    }

    @Test
    public void shouldStartWithBorrowedFalse() {
        assertFalse(testBook.isBorrowed());
    }

    @Test
    public void setBorrowed() {
        testBook.setBorrowed(true);
        assertTrue(testBook.isBorrowed());
    }

    @Test
    public void shouldTransformToString() {
        assertThat("|       1 | Test Title                                                            | Test Author                   | 13/04/1992 |", is(testBook.toString()));
    }
}