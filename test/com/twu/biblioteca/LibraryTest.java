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
    public void shouldReturnABook() {
        assertNotNull(is(testLibrary.getBook("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary")));
        assertNotNull(is(testLibrary.getBook(3)));
    }

    @Test
    public void shouldCheckoutABook() {
        testLibrary.checkoutBook(1);
        assertTrue(testLibrary.getBook(1).isBorrowed());

        testLibrary.checkoutBook("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary");
        assertTrue(testLibrary.getBook("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").isBorrowed());
    }

    @Test
    public void shouldShowOnlyNotBorrowedBooks() {
        testLibrary.checkoutBook(1);
        testLibrary.checkoutBook("Harry Potter and the Prisoner of Azkaban");
        assertEquals(3, testLibrary.toString().split("\n").length);
    }

    @Test
    public void shouldReturnASuccessfulMessageAfterCheckout() {
        assertThat("Thank you! Enjoy the book", is(testLibrary.checkoutBook(1)));
        assertThat("Thank you! Enjoy the book", is(testLibrary.checkoutBook("Harry Potter and the Prisoner of Azkaban")));
    }

    @Test
    public void shouldReturnAnUnsuccessfulMessageIfBookIsBorrowed() {
        testLibrary.checkoutBook(1);
        assertThat("Sorry, that book is not available", is(testLibrary.checkoutBook("A Game of Thrones")));

        testLibrary.checkoutBook("Harry Potter and the Prisoner of Azkaban");
        assertThat("Sorry, that book is not available", is(testLibrary.checkoutBook(3)));

        assertThat("Sorry, that book is not available", is(testLibrary.checkoutBook(123)));
        assertThat("Sorry, that book is not available", is(testLibrary.checkoutBook("Harry Potterson")));
    }
}