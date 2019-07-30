package com.twu.biblioteca.products;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class MovieTest {
    Movie testMovie;

    @Before
    public void setUp() throws Exception {
        testMovie = new Movie(1, "Test Title Movie", 1972, "Test Director", 1);
    }

    @Test
    public void shouldCheckProperties() {
        assertThat(testMovie.getId(), is(1));
        assertThat(testMovie.getTitle(), is("Test Title Movie"));
        assertThat(testMovie.getYearPublished(), is(1972));
        assertThat(testMovie.getDirector(), is("Test Director"));
        assertThat(testMovie.parseRating(), is("1"));
        assertFalse(testMovie.isBorrowed());
    }

    @Test
    public void setBorrowed() {
        testMovie.setBorrowed(true);
        assertTrue(testMovie.isBorrowed());
    }

    @Test
    public void formatProductShowHeader() {
        assertThat(testMovie.toString(), is("|       1 | Test Title Movie                                                      | Test Director                 | 1972         |       1 |"));
    }

    @Test
    public void canBeUnrated() {
        Movie testMovie2 = new Movie(1, "Test Title Movie", 1972, "Test Director");
        assertThat(testMovie2.parseRating(), is("Unrated"));
    }
}