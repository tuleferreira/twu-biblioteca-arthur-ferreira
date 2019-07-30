package com.twu.biblioteca.sections;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.products.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SectionTest {
    private Section testSection;

    @Before
    public void setUp() {
        testSection = new Section("Test Item", "Test Section");

        testSection.setProductsList(Arrays.asList(
                new Book(1, "A Game of Thrones", "George R. R. Martin", 1996, 8, 1),
                new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", 2019, 8, 1),
                new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 7, 8),
                new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", 2019, 7, 16)));

        BibliotecaApp.libraryNumberConnected = "472-6231";
        testSection.checkoutProduct(4);
    }

    @Test
    public void shouldGetAProductByNameOrID() {
        assertNotNull(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary"));
        assertNotNull(testSection.getProduct(3));
    }

    @Test
    public void shouldCheckoutAProductByNameOrID() {
        testSection.checkoutProduct(1);
        assertTrue(testSection.getProduct(1).isBorrowed());
        assertThat(testSection.getProduct(1).getBorrowedBy(), is("472-6231"));

        testSection.checkoutProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary");
        assertTrue(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").isBorrowed());
        assertThat(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").getBorrowedBy(), is("472-6231"));
    }

    @Test
    public void shouldTestSuccessfulCheckoutMessages() {
        assertThat(testSection.checkoutProduct(1), is("Thank you! Enjoy the test item."));
        assertThat(testSection.checkoutProduct("Harry Potter and the Prisoner of Azkaban"), is("Thank you! Enjoy the test item."));
    }

    @Test
    public void shouldTestUnsuccessfulCheckoutMessages() {
        assertThat(testSection.checkoutProduct(4), is("Sorry, that test item is not available."));
        assertThat(testSection.checkoutProduct(123), is("Sorry, that test item is not available."));
        assertThat(testSection.checkoutProduct("Harry Peterson"), is("Sorry, that test item is not available."));
    }

    @Test
    public void shouldReturnAProductByNameOrID() {
        testSection.returnProduct(4);
        assertFalse(testSection.getProduct(4).isBorrowed());
        assertNull(testSection.getProduct(4).getBorrowedBy());

        testSection.checkoutProduct("Talking to Robots : A Brief Guide to Our Human-Robot Futures");
        testSection.returnProduct("Talking to Robots : A Brief Guide to Our Human-Robot Futures");
        assertFalse(testSection.getProduct("Talking to Robots : A Brief Guide to Our Human-Robot Futures").isBorrowed());
        assertNull(testSection.getProduct("Talking to Robots : A Brief Guide to Our Human-Robot Futures").getBorrowedBy());
    }

    @Test
    public void shouldTestSuccessfulReturningMessages() {
        assertThat(testSection.returnProduct(4), is("Thank you for returning the test item."));
    }

    @Test
    public void shouldTestUnsuccessfulReturningMessages() {
        assertThat(testSection.returnProduct(91231), is("That is not a valid test item to return."));
        assertThat(testSection.returnProduct("Wrong Product Title to Test Unsuccessful Message"), is("That is not a valid test item to return."));
    }

    @Test
    public void shouldBorrowAProductWithWrongWordCase() {
        testSection.checkoutProduct("A GAME OF THRONES");
        assertTrue(testSection.getProduct("A Game of Thrones").isBorrowed());
    }

    @Test
    public void shouldReturnAProductWithWrongWordCase() {
        testSection.returnProduct("Talking to Robots : A Brief Guide to Our Human-Robot Futures");
        assertFalse(testSection.getProduct("A Game of Thrones").isBorrowed());
    }

    @Test
    public void subMenuShouldFailWithWrongOptionsInput() {
        assertThat(testSection.getMenu().getOption(-1), is("Please select a valid option!"));
    }

    @Test
    public void testBorrowedByUserToString() {
        assertThat(testSection.toString(BibliotecaApp.libraryNumberConnected),
                is("|      ID | BOOK                                                                  | AUTHOR                        | PUBLISHED  |\n" +
                        "|       4 | Talking to Robots : A Brief Guide to Our Human-Robot Futures          | David Ewing Duncan            | 16/07/2019 |\n"));

        testSection.returnProduct(4);
        assertThat(testSection.toString(BibliotecaApp.libraryNumberConnected), is("Test Section: You have nothing borrowed\n"));
    }

    @Test
    public void subMenuToString() {
        assertThat(testSection.getMenu().toString(), is("Choose between those options:\n" +
                "0 - Go back.\n" +
                "1 - List all test items.\n" +
                "2 - Checkout test item.\n" +
                "3 - Returning test item.\n"));
    }
}