package com.twu.biblioteca.sections;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.products.Product;
import com.twu.biblioteca.users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SectionTest {
    private Section testSection;

    private final User kendrickLamar = new User(
            "Kendrick Lamar",
            "kendrick.lamar@hotmail.com",
            "9999999",
            "123-4567",
            "lam@r"
    );
    private Section testSection2;

    @Before
    public void setUp() {
        MainMenu.getInstance().setLoggedInUser(kendrickLamar);

        testSection = new Section("Test Item", "Test Section", Arrays.asList(
                new Product("Title 1", "header"),
                new Product("Title 2", "header")
        ));
    }

    @Test
    public void shouldGetAProductByNameOrID() {
        assertNotNull(testSection.getProduct("Title 1"));
        assertNotNull(testSection.getProduct(1));
    }

    @Test
    public void shouldCheckoutByNameOrID() {
        testSection.checkoutProduct(1);
        assertTrue(testSection.getProduct(1).get().isBorrowed());
        assertThat(testSection.getProduct(1).get().getBorrowedBy().get(), is("123-4567"));

        testSection.checkoutProduct("Title 2");
        assertTrue(testSection.getProduct("Title 2").get().isBorrowed());
        assertThat(testSection.getProduct("Title 2").get().getBorrowedBy().get(), is("123-4567"));
    }

    @Test
    public void checkCheckoutMessages() {
        assertThat(testSection.checkoutProduct(1), is("Thank you! Enjoy the 'Title 1'."));
        assertThat(testSection.checkoutProduct("Title 2"), is("Thank you! Enjoy the 'Title 2'."));

        assertThat(testSection.checkoutProduct(1), is("Sorry, the 'Title 1' is not available."));

        assertThat(testSection.checkoutProduct(1111), is("Sorry, this test item doesn't exist."));
        assertThat(testSection.checkoutProduct("Wrong title"), is("Sorry, this test item doesn't exist."));
    }

    @Test
    public void shouldReturnByNameOrID() {
        testSection.checkoutProduct(1);
        testSection.returnProduct(1);
        assertFalse(testSection.getProduct(1).get().isBorrowed());
        assertThat(testSection.getProduct(1).get().getBorrowedBy(), is(Optional.empty()));

        testSection.checkoutProduct("Title 2");
        testSection.returnProduct("Title 2");
        assertFalse(testSection.getProduct("Title 2").get().isBorrowed());
        assertThat(testSection.getProduct("Title 2").get().getBorrowedBy(), is(Optional.empty()));
    }

    @Test
    public void checkReturnMessages() {
        testSection.checkoutProduct(1);
        assertThat(testSection.returnProduct(1), is("Thank you for returning the 'Title 1'."));

        assertThat(testSection.returnProduct(1), is("Sorry, the 'Title 1' is not borrowed."));

        assertThat(testSection.returnProduct(91231), is("Sorry, this test item doesn't exist."));
        assertThat(testSection.returnProduct("Wrong title"), is("Sorry, this test item doesn't exist."));
    }

    @Test
    public void shouldCheckoutIgnoreCase() {
        testSection.checkoutProduct("TITLE 1");
        assertTrue(testSection.getProduct("Title 1").get().isBorrowed());
    }

    @Test
    public void shouldReturnIgnoreCase() {
        testSection.checkoutProduct("Title 1");
        testSection.returnProduct("TITLE 1");
        assertFalse(testSection.getProduct("Title 1").get().isBorrowed());
    }

    @Test
    public void shouldGetBorrowedList() {
        testSection.checkoutProduct(1);
        testSection.checkoutProduct(2);
        assertThat(testSection.getBorrowedList(), is(
                String.format(
                        "%s\n%s\n%s\n%s",
                        "Test Section:",
                        "header",
                        "Title 1",
                        "Title 2"
                )
        ));

        testSection.returnProduct(1);
        testSection.returnProduct(2);
        assertThat(testSection.getBorrowedList(), is(
                String.format(
                        "%s\n%s",
                        "Test Section:",
                        "You have nothing borrowed"
                )
        ));
    }

    @Test
    public void checkToString() {
        assertThat(testSection.getMenu().toString(), is(
                String.format(
                        "%s\n%s\n%s\n%s\n%s",
                        "Choose between those options:",
                        "0 - Go back.",
                        "1 - List all test items.",
                        "2 - Checkout test item.",
                        "3 - Returning test item."
                )
        ));
    }
}