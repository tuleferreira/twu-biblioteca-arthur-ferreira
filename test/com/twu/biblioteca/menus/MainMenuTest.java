package com.twu.biblioteca.menus;

import com.twu.biblioteca.products.Book;
import com.twu.biblioteca.products.Movie;
import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MainMenuTest {
    private MainMenu menu;

    @Before
    public void setUp() {
        menu = new MainMenu(new User("A", "a@a", "999", "123900", "abc"));

        menu.addSection(new Section("Book", "Library", Arrays.asList(
                new Book(1, "A Game of Thrones", "George R. R. Martin", 1992, 8, 1),
                new Book(2, "Thoughts of Dog 2019-2020 16-Month Weekly/Monthly Diary", "Matt Nelson", 2019, 8, 1),
                new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999, 7, 8),
                new Book(4, "Talking to Robots : A Brief Guide to Our Human-Robot Futures", "David Ewing Duncan", 2019, 7, 16)
        )));
        menu.addSection(new Section("Movie", "Movies Section", Arrays.asList(
                new Movie(1, "The Godfather", 1972, "Francis Ford Coppola", 10),
                new Movie(2, "The Dark Knight", 2008, "Christopher Nolan", 9),
                new Movie(3, "Casablanca", 1942, "Michael Curtiz", 9),
                new Movie(4, "Schindler's List", 1993, "Steven Spielberg")
        )));
    }

    @Test
    public void checkWelcomeMessage() {
        assertThat(menu.WELCOME_MESSAGE, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore"));
    }

    @Test
    public void shouldHaveInformationAndCheckedOutOption() {
        assertThat(menu.getOption(1), is("View my information"));
        assertThat(menu.getOption(2), is("View checked out list"));
    }

    @Test
    public void shouldIndexSectionsInOrder() {
        assertThat(menu.getOption(3), is("Library"));
        assertThat(menu.getOption(4), is("Movies Section"));
    }

    @Test
    public void checkInvalidOptionMessage() {
        assertThat(menu.getOption(-1), is("Please select a valid option!"));
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