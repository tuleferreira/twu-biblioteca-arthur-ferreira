package com.twu.biblioteca;

import org.junit.Test;

import java.util.Date;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Test
    public void constructorTest() {
        testBook = new Book("1", "Test", "Test Author", "Test Category", "Test Description", new Date(1992, 04, 13), 5);
        assertThat("Test", is(testBook.getName()));
        assertThat("Test Author", is(testBook.getAuthor()));
        assertThat("Test Category", is(testBook.getCategory()));
        assertThat("Test Description", is(testBook.getDescription()));
        assertThat(13, is(testBook.getPublishDate().getDate()));
        assertThat(4, is(testBook.getPublishDate().getMonth()));
        assertThat(1992, is(testBook.getPublishDate().getYear()));
        assertThat(5, is(testBook.getRating()));
    }
}