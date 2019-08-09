package com.twu.biblioteca.menus;

import com.twu.biblioteca.products.Book;
import com.twu.biblioteca.products.Movie;
import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTest {
    private MainMenu menu;
    private Section librarySection;
    private Section moviesSection;

    @Before
    public void setUp() {
        User loggedInUser = new User("A", "a@a", "999", "123900", "abc");
        menu = new MainMenu(loggedInUser);

        librarySection = new Section("Book", "Library",
                Collections.singletonList(new Book("title", "author", 1992, 4, 13)),
                loggedInUser);
        moviesSection = new Section("Movie", "Movies Section",
                Collections.singletonList(new Movie("title", 1992, "director")),
                loggedInUser);

        menu.addSection(librarySection);
        menu.addSection(moviesSection);
    }

    @Test
    public void checkWelcomeMessage() {
        assertThat(menu.WELCOME_MESSAGE, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore"));
    }

    @Test
    public void shouldHaveInformationAndCheckedOutOption() {
        assertThat(menu.options.get(1).title, is("View my information"));
        assertThat(menu.options.get(2).title, is("View checked out list"));
    }

    @Test
    public void shouldIndexSectionsInOrder() {
        assertThat(menu.options.get(3).title, is("Library"));
        assertThat(menu.options.get(4).title, is("Movies Section"));
    }

    @Test
    public void checkInvalidOptionMessage() {
        assertThat(menu.INVALID_OPTION, is("Please select a valid option!"));
    }

    @Test
    public void shouldGetBorrowedListsOfSections() {
        assertThat(menu.getBorrowedListsOfSections(),
                is("Library:\n" + "You have nothing borrowed\n" +
                        "\n" +
                        "Movies Section:\n" + "You have nothing borrowed"));
    }

    @Test
    public void checkToString() {
        assertThat(menu.toString(), is("Choose between those options:\n" +
                "0 - Quit.\n" +
                "1 - View my information.\n" +
                "2 - View checked out list.\n" +
                "3 - Library.\n" +
                "4 - Movies Section.\n"));
    }
}