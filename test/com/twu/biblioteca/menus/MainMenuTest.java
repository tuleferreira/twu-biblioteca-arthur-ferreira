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
    public void shouldHaveViewInformationOption() {
        assertThat(menu.getOption(1), is("View my information"));
    }

    @Test
    public void shouldHaveViewChekedOutOption() {
        assertThat(menu.getOption(2), is("View checked out list"));
    }

    @Test
    public void shouldIndexOptionsByIntegerValue() {
        assertThat(menu.getOption(3), is("Library"));
    }

    @Test
    public void shouldFailWithWrongOptionsInput() {
        assertThat(menu.getOption(-1), is("Please select a valid option!"));
    }

    @Test
    public void shouldTransformToString() {
        assertThat(menu.toString(), is("Choose between those options:\n" +
                "0 - Quit.\n" +
                "1 - View my information.\n" +
                "2 - View checked out list.\n" +
                "3 - Library.\n" +
                "4 - Movies Section.\n"));
    }
}