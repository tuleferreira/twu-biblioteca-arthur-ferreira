package com.twu.biblioteca.menus;

import com.twu.biblioteca.products.Book;
import com.twu.biblioteca.products.Movie;
import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTest {
    private MainMenu menu;
    private User loggedInUser = new User(
            "A",
            "a@a",
            "999",
            "123-9000",
            "abc"
    );

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        //Reset Singleton
        Field instance = MainMenu.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);

        menu = MainMenu.getInstance();

        menu.setLoggedInUser(loggedInUser);
        menu.addSection(new Section(
                "Book",
                "Library",
                Collections.singletonList(new Book("title", "author", 1992, 4, 13))
        ));
        menu.addSection(new Section(
                "Movie",
                "Movies Section",
                Collections.singletonList(new Movie("title", 1992, "director"))
        ));
    }

    @Test
    public void shouldHaveViewInformation() {
        assertThat(menu.options.get(1).title, is("View my information"));
    }

    @Test
    public void shouldHaveCheckedOut() {
        assertThat(menu.options.get(2).title, is("View checked out list"));
    }

    @Test
    public void shouldHaveSectionOption() {
        assertThat(menu.options.get(3).title, is("Library"));
        assertThat(menu.options.get(4).title, is("Movies Section"));
    }

    @Test
    public void checkInvalidOptionMessage() {
        assertThat(Menu.INVALID_OPTION, is("Please select a valid option!"));
    }

    @Test
    public void shouldGetBorrowedListsOfSections() {
        assertThat(menu.getBorrowedListsOfSections(), containsString("Library:"));
        assertThat(menu.getBorrowedListsOfSections(), containsString("Movies Section:"));
    }

    @Test
    public void checkToString() {
        assertThat(menu.toString(), is(String.format("%s\n%s\n%s\n%s\n%s\n%s",
                "Choose between those options:",
                "0 - Quit.",
                "1 - View my information.",
                "2 - View checked out list.",
                "3 - Library.",
                "4 - Movies Section."
                )
        ));
    }
}