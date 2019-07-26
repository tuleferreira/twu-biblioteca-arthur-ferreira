package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library testLibrary;

    @Before
    public void setUp() {
        testLibrary = new Library();
        testLibrary.checkoutBook(4);
    }

    @Test
    public void shouldShowBooks() {
        assertEquals(4, testLibrary.toString().split("\n").length);
    }

    @Test
    public void shouldGetABookByNameOrID() {
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
        assertEquals(2, testLibrary.toString().split("\n").length);
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

    @Test
    public void shouldReturnABookSuccessfully() {
        assertTrue(testLibrary.getBook(4).isBorrowed());
        assertThat("Thank you for returning the book", is(testLibrary.returnBook(4)));
        assertFalse(testLibrary.getBook(4).isBorrowed());

        testLibrary.checkoutBook("Talking to Robots : A Brief Guide to Our Human-Robot Futures");

        assertTrue(testLibrary.getBook("Talking to Robots : A Brief Guide to Our Human-Robot Futures").isBorrowed());
        assertThat("Thank you for returning the book", is(testLibrary.returnBook("Talking to Robots : A Brief Guide to Our Human-Robot Futures")));
        assertFalse(testLibrary.getBook("Talking to Robots : A Brief Guide to Our Human-Robot Futures").isBorrowed());

        assertEquals(5, testLibrary.toString().split("\n").length);
    }

    @Test
    public void shouldGiveAMessageForAnUnsuccessfulReturn() {
        assertThat("Thank you for returning the book", is(testLibrary.returnBook(4)));
        assertThat("That is not a valid book to return.", is(testLibrary.returnBook(4)));

        assertThat("That is not a valid book to return.", is(testLibrary.returnBook(9)));
        assertThat("That is not a valid book to return.", is(testLibrary.returnBook("Wrong Book Title to Test Unsuccessful Message")));
    }

    @Test
    public void shouldBorrowABookWithWrongWordCase() {
        assertThat("Thank you! Enjoy the book", is(testLibrary.checkoutBook("A GAME OF THRONES")));
    }

    @Test
    public void shouldReturnABookWithWrongWordCase() {
        testLibrary.checkoutBook(1);
        assertThat("Thank you for returning the book", is(testLibrary.returnBook("A GAME OF THRONES")));
    }
}