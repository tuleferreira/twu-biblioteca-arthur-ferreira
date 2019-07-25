package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void shouldIndexOptionsByIntegerValue() {
        assertThat("List of books", is(menu.getOption(1)));
    }

    @Test
    public void shouldFailWhithWrongOptionsInput() {
        assertThat("Please select a valid option!", is(menu.getOption(-1)));
    }

    @Test
    public void shouldTransformToString() {
        assertThat("Choose between those options:\n" +
                "0 - Quit.\n" +
                "1 - List of books.\n" +
                "2 - Checkout a book.\n" +
                "3 - Returning a book.\n", is(menu.toString()));
    }
}