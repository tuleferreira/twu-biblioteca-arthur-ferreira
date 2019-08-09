//package com.twu.biblioteca.sections;
//
//import com.twu.biblioteca.products.Book;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//
//public class SectionTest {
//    private Section testSection;
//
//    @Before
//    public void setUp() {
//        testSection = new Section("Test Item", "Test Section", Book.parseTxt("./src/books.csv"), loggedUser);
//
//        testSection.checkoutProduct(4, "472-6231");
//    }
//
//    @Test
//    public void shouldGetAProductByNameOrID() {
//        assertNotNull(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary"));
//        assertNotNull(testSection.getProduct(3));
//    }
//
//    @Test
//    public void shouldCheckoutByNameOrID() {
//        testSection.checkoutProduct(1, "472-6231");
//        assertTrue(testSection.getProduct(1).isBorrowed());
//        assertThat(testSection.getProduct(1).getBorrowedBy(), is("472-6231"));
//
//        testSection.checkoutProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "472-6231");
//        assertTrue(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").isBorrowed());
//        assertThat(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").getBorrowedBy(), is("472-6231"));
//    }
//
//    @Test
//    public void checkCheckoutMessages() {
//        assertThat(testSection.checkoutProduct(1, "472-6231"), is("Thank you! Enjoy the test item."));
//        assertThat(testSection.checkoutProduct("Harry Potter and the Prisoner of Azkaban", "472-6231"), is("Thank you! Enjoy the test item."));
//
//        assertThat(testSection.checkoutProduct(4, "472-6231"), is("Sorry, that test item is not available."));
//        assertThat(testSection.checkoutProduct(123, "472-6231"), is("Sorry, that test item is not available."));
//        assertThat(testSection.checkoutProduct("Harry Peterson", "472-6231"), is("Sorry, that test item is not available."));
//    }
//
//    @Test
//    public void shouldReturnByNameOrID() {
//        testSection.returnProduct(4);
//        assertFalse(testSection.getProduct(4).isBorrowed());
//        assertNull(testSection.getProduct(4).getBorrowedBy());
//
//        testSection.checkoutProduct("Talking to Robots: A Brief Guide to Our Human-Robot Futures", "472-6231");
//        testSection.returnProduct("Talking to Robots: A Brief Guide to Our Human-Robot Futures");
//        assertFalse(testSection.getProduct("Talking to Robots: A Brief Guide to Our Human-Robot Futures").isBorrowed());
//        assertNull(testSection.getProduct("Talking to Robots: A Brief Guide to Our Human-Robot Futures").getBorrowedBy());
//    }
//
//    @Test
//    public void checkReturnMessages() {
//        assertThat(testSection.returnProduct(4), is("Thank you for returning the test item."));
//
//        assertThat(testSection.returnProduct(91231), is("That is not a valid test item to return."));
//        assertThat(testSection.returnProduct("Wrong Product Title to Test Unsuccessful Message"), is("That is not a valid test item to return."));
//    }
//
//    @Test
//    public void shouldCheckoutIgnoreCase() {
//        testSection.checkoutProduct("A GAME OF THRONES", "472-6231");
//        assertTrue(testSection.getProduct("A Game of Thrones").isBorrowed());
//    }
//
//    @Test
//    public void shouldReturnIgnoreCase() {
//        testSection.returnProduct("Talking to Robots: A Brief Guide to Our Human-Robot Futures");
//        assertFalse(testSection.getProduct("A Game of Thrones").isBorrowed());
//    }
//
//    @Test
//    public void checkSectionMenuInvalidOption() {
//        assertThat(testSection.getMenu().INVALID_OPTION, is("Please select a valid option!"));
//    }
//
//    @Test
//    public void shouldGetBorrowedListByLibNumber() {
//        assertThat(testSection.getBorrowedList("472-6231"),
//                is("Test Section:\n" +
//                        "|      ID | BOOK                                                                  | AUTHOR                        | PUBLISHED  |\n" +
//                        "|       4 | Talking to Robots: A Brief Guide to Our Human-Robot Futures           | David Ewing Duncan            | 16/07/2019 |"));
//
//        testSection.returnProduct(4);
//        assertThat(testSection.getBorrowedList("472-6231"), is("Test Section:\n" + "You have nothing borrowed"));
//    }
//
//    @Test
//    public void checkToString() {
//        assertThat(testSection.getMenu().toString(), is("Choose between those options:\n" +
//                "0 - Go back.\n" +
//                "1 - List all test items.\n" +
//                "2 - Checkout test item.\n" +
//                "3 - Returning test item.\n"));
//    }
//}