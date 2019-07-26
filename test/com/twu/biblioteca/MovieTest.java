package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    Movie testMovie;

    @Before
    public void setUp() throws Exception {
        testMovie = new Movie(1, "Test Title Movie", 1972, "Test Director", 1);
    }

    @Test
    public void shouldTransformToString() {
        assertThat("|       1 | Test Title Movie                                                      | Test Director                 | 1972         |       1 |", is(testMovie.toString()));
    }

    @Test
    public void shouldHasUnratedWhenRatingIsNull() {
        testMovie = new Movie(1, "Test Title Movie", 1972, "Test Director");
        assertThat("|       1 | Test Title Movie                                                      | Test Director                 | 1972         | Unrated |", is(testMovie.toString()));
    }
}