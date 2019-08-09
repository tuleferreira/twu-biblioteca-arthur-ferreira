package com.twu.biblioteca.products;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookParserTest {
    private BookParser bookParser;

    @Before
    public void setUp() {
        bookParser = new BookParser();
    }

    @Test
    public void shouldParseLine() {
        String[] attributes;
        Book book;

        attributes = new String[]{"title", "author", "13/04/1992"};
        book = bookParser.parse(attributes);

        assertThat(book.getTitle(), is("title"));
        assertThat(book.getAuthor(), is("author"));
        assertThat(book.getPublishDate().getDayOfMonth(), is(13));
        assertThat(book.getPublishDate().getMonthValue(), is(4));
        assertThat(book.getPublishDate().getYear(), is(1992));
    }
}