package com.twu.biblioteca.products;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    Movie testMovie;

    @Before
    public void setUp() {
        testMovie = new Movie( "Test Title Movie", 1972, "Test Director", 1);
    }

    @Test
    public void checkProductHeader() {
        assertThat(testMovie.toString(), is("|       0 | Test Title Movie                                                      | Test Director                 | 1972         |       1 |"));
    }

    @Test
    public void shouldParseUnrated() {
        Movie testMovie2 = new Movie("Test Title Movie", 1972, "Test Director");
        assertThat(testMovie2.getRating(), is("Unrated"));
    }

    @Test
    public void checkToString() {
        assertThat(testMovie.toString(), CoreMatchers.is("|       0 | Test Title Movie                                                      | Test Director                 | 1972         |       1 |"));
    }
}