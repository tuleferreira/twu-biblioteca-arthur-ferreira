package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library testLibrary;

    @Before
    public void setUp() throws Exception {
        testLibrary = new Library();
    }

    @Test
    public void shouldContainAddedBooks() {
        assertEquals(4, testLibrary.getBooksList().size());
    }

    @Test
    public void shouldShowBooks() {
        assertEquals(5, testLibrary.toString().split("\n").length);
    }

    @Test
    public void shouldCheckoutABook() {
        testLibrary.checkoutBook(1);

        assertFalse(testLibrary.getBooksList().get(1).isBorrowed());
        assertTrue(testLibrary.getBookById(1).isBorrowed());
    }

    @Test
    public void shouldShowOnlyNotBorrowedBooks() {
        testLibrary.checkoutBook(1);

        assertEquals(4, testLibrary.toString().split("\n").length);
    }

    @Test
    public void shouldReturnASuccessfulMessageAfterCheckout() {
        assertThat("Thank you! Enjoy the book", is(testLibrary.checkoutBook(1)));
    }

    @Test
    public void shouldReturnAnUnsuccessfulMessageIfBookIsBorrowed() {
        testLibrary.checkoutBook(1);

        assertThat("Sorry, that book is not available", is(testLibrary.checkoutBook(1)));
        assertThat("Sorry, that book is not available", is(testLibrary.checkoutBook(123)));
    }
}