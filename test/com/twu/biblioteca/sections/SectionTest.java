//package com.twu.biblioteca.sections;
//
//import com.twu.biblioteca.BibliotecaApp;
//import com.twu.biblioteca.menus.MainMenu;
//import com.twu.biblioteca.products.BookParser;
//import com.twu.biblioteca.users.User;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;
//
//public class SectionTest {
//    private Section testSection;
//
//    @Before
//    public void setUp() throws IOException {
//        MainMenu.getInstance().setLoggedInUser(
//                new User(
//                        "Kendrick Lamar",
//                        "kendrick.lamar@hotmail.com",
//                        "9999999",
//                        "123-4567",
//                        "lam@r"
//                )
//        );
//
//        testSection = new Section(
//                "Test Item",
//                "Test Section",
//                BibliotecaApp.parseTxt("./src/books.csv", new BookParser())
//        );
//
//        testSection.checkoutProduct(4);
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
//        testSection.checkoutProduct(1);
//        assertTrue(testSection.getProduct(1).isBorrowed());
//        assertThat(testSection.getProduct(1).getBorrowedBy(), is("123-4567"));
//
//        testSection.checkoutProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary");
//        assertTrue(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").isBorrowed());
//        assertThat(testSection.getProduct("Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary").getBorrowedBy(), is("123-4567"));
//    }
//
//    @Test
//    public void checkCheckoutMessages() {
//        assertThat(testSection.checkoutProduct(1), is("Thank you! Enjoy the test item."));
//        assertThat(testSection.checkoutProduct("Harry Potter and the Prisoner of Azkaban"), is("Thank you! Enjoy the test item."));
//
//        assertThat(testSection.checkoutProduct(4), is("Sorry, that test item is not available."));
//        assertThat(testSection.checkoutProduct(123), is("Sorry, that test item is not available."));
//        assertThat(testSection.checkoutProduct("Harry Peterson"), is("Sorry, that test item is not available."));
//    }
//
//    @Test
//    public void shouldReturnByNameOrID() {
//        testSection.returnProduct(4);
//        assertFalse(testSection.getProduct(4).isBorrowed());
//        assertNull(testSection.getProduct(4).getBorrowedBy());
//
//        testSection.checkoutProduct("Talking to Robots: A Brief Guide to Our Human-Robot Futures");
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
//        testSection.checkoutProduct("A GAME OF THRONES");
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
//        assertThat(testSection.getMenu().getInvalidOption(), is("Please select a valid option!"));
//    }
//
//    @Test
//    public void shouldGetBorrowedListByLibNumber() {
//        assertThat(testSection.getBorrowedList(),
//                is("Test Section:\n" +
//                        "|      ID | BOOK                                                                  | AUTHOR                        | PUBLISHED  |\n" +
//                        "|       4 | Talking to Robots: A Brief Guide to Our Human-Robot Futures           | David Ewing Duncan            | 16/07/2019 |"));
//
//        testSection.returnProduct(4);
//        assertThat(testSection.getBorrowedList(), is("Test Section:\n" + "You have nothing borrowed"));
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