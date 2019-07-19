package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUp() {
        testBook = new Book("1", "Test", "Test Author", "Test Category", "Test Description", LocalDate.of(1992, 04, 13), 5);
    }

    @Test
    public void constructorTest() {
        assertThat("Test", is(testBook.getName()));
        assertThat("Test Author", is(testBook.getAuthor()));
        assertThat("Test Category", is(testBook.getCategory()));
        assertThat("Test Description", is(testBook.getDescription()));
        assertThat(13, is(testBook.getPublishDate().getDayOfMonth()));
        assertThat(4, is(testBook.getPublishDate().getMonthValue()));
        assertThat(1992, is(testBook.getPublishDate().getYear()));
        assertThat(5, is(testBook.getRating()));
    }

    @Test
    public void bookToString() {
        assertThat("Test - Test Author, published in 13/4/1992 and rated 5. ID: 1", is(testBook.toString()));
    }
}