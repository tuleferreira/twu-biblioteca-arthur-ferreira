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
        assertThat(1, is(testMovie.getId()));
        assertThat("Test Title Movie", is(testMovie.getTitle()));
        assertThat(1972, is(testMovie.getYearPublished()));
        assertThat("Test Director", is(testMovie.getDirector()));
        assertThat("1", is(testMovie.parseRating()));
        assertFalse(testMovie.isBorrowed());
    }

    @Test
    public void setBorrowed() {
        testMovie.setBorrowed(true);
        assertTrue(testMovie.isBorrowed());
    }

    @Test
    public void formatProductShowHeader() {
        assertThat("|       1 | Test Title Movie                                                      | Test Director                 | 1972         |       1 |", is(testMovie.toString()));
    }

    @Test
    public void canBeUnrated() {
        Movie testMovie2 = new Movie(1, "Test Title Movie", 1972, "Test Director");
        assertThat("Unrated", is(testMovie2.parseRating()));
    }
}