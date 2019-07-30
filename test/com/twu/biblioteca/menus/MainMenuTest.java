package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.BooksSection;
import com.twu.biblioteca.sections.MoviesSection;
import com.twu.biblioteca.sections.Section;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTest {
    private MainMenu menu;

    @Before
    public void setUp() {
        Section booksSection = new BooksSection("Book", "Library");
        Section moviesSection = new MoviesSection("Movie", "Movies Section");

        menu = new MainMenu();

        menu.addSection(booksSection);
        menu.addSection(moviesSection);
    }

    @Test
    public void shouldHaveViewChekedOutOption() {
        assertThat("View checked out list", is(menu.getOption(1)));
    }

    @Test
    public void shouldIndexOptionsByIntegerValue() {
        assertThat("Library", is(menu.getOption(2)));
    }

    @Test
    public void shouldFailWithWrongOptionsInput() {
        assertThat("Please select a valid option!", is(menu.getOption(-1)));
    }

    @Test
    public void shouldTransformToString() {
        assertThat("Choose between those options:\n" +
                "0 - Quit.\n" +
                "1 - View checked out list.\n" +
                "2 - Library.\n" +
                "3 - Movies Section.\n", is(menu.toString()));
    }
}