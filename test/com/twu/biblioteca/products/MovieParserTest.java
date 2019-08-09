package com.twu.biblioteca.products;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieParserTest {
    private MovieParser movieParser;

    @Before
    public void setUp() {
        movieParser = new MovieParser();
    }

    @Test
    public void shouldParseLine() {
        String[] attributes;
        Movie movie;

        attributes = new String[]{"title", "1992", "director", "1"};
        movie = movieParser.parse(attributes);

        assertThat(movie.getTitle(), is("title"));
        assertThat(movie.getYearPublished(), is(1992));
        assertThat(movie.getDirector(), is("director"));
        assertThat(movie.getRating(), is("1"));

        attributes = new String[]{"title", "1992", "director"};
        movie = movieParser.parse(attributes);

        assertThat(movie.getTitle(), is("title"));
        assertThat(movie.getYearPublished(), is(1992));
        assertThat(movie.getDirector(), is("director"));
        assertThat(movie.getRating(), is("Unrated"));
    }
}