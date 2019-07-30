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
        assertNotNull(is(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary")));
        assertNotNull(is(testSection.getProduct(3)));
    }

    @Test
    public void shouldCheckoutAProductByNameOrID() {
        testSection.checkoutProduct(1);
        assertTrue(testSection.getProduct(1).isBorrowed());
        assertThat("472-6231", is(testSection.getProduct(1).getBorrowedBy()));

        testSection.checkoutProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary");
        assertTrue(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").isBorrowed());
        assertThat("472-6231", is(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").getBorrowedBy()));
    }

    @Test
    public void shouldTestSuccessfulCheckoutMessages() {
        assertThat("Thank you! Enjoy the test item.", is(testSection.checkoutProduct(1)));
        assertThat("Thank you! Enjoy the test item.", is(testSection.checkoutProduct("Harry Potter and the Prisoner of Azkaban")));
    }

    @Test
    public void shouldTestUnsuccessfulCheckoutMessages() {
        assertThat("Sorry, that test item is not available.", is(testSection.checkoutProduct(4)));
        assertThat("Sorry, that test item is not available.", is(testSection.checkoutProduct(123)));
        assertThat("Sorry, that test item is not available.", is(testSection.checkoutProduct("Harry Peterson")));
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
        assertThat("Thank you for returning the test item.", is(testSection.returnProduct(4)));
    }

    @Test
    public void shouldTestUnsuccessfulReturningMessages() {
        assertThat("That is not a valid test item to return.", is(testSection.returnProduct(91231)));
        assertThat("That is not a valid test item to return.", is(testSection.returnProduct("Wrong Product Title to Test Unsuccessful Message")));
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
        assertThat("Please select a valid option!", is(testSection.getMenu().getOption(-1)));
    }

    @Test
    public void testBorrowedByUserToString() {
        assertThat("|      ID | BOOK                                                                  | AUTHOR                        | PUBLISHED  |\n" +
                "|       4 | Talking to Robots : A Brief Guide to Our Human-Robot Futures          | David Ewing Duncan            | 16/07/2019 |\n", is(testSection.toString(BibliotecaApp.libraryNumberConnected)));

        testSection.returnProduct(4);
        assertThat( "Test Section: You have nothing borrowed\n", is(testSection.toString(BibliotecaApp.libraryNumberConnected)));
    }

    @Test
    public void subMenuToString() {
        assertThat("Choose between those options:\n" +
                "0 - Go back.\n" +
                "1 - List all test items.\n" +
                "2 - Checkout test item.\n" +
                "3 - Returning test item.\n", is(testSection.getMenu().toString()));
    }
}