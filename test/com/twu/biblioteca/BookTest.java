package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class BookTest {
    private Book testBook;

    @Before
    public void setUp() {
        testBook = new Book(1, "Test Title", "Test Author", "Test Category", "Test Description", LocalDate.of(1992, 04, 13), 5);
    }

    @Test
    public void shouldContainExpectedProperties() {
        assertThat("Test Title", is(testBook.getName()));
        assertThat("Test Author", is(testBook.getAuthor()));
        assertThat("Test Category", is(testBook.getCategory()));
        assertThat("Test Description", is(testBook.getDescription()));
        assertThat(13, is(testBook.getPublishDate().getDayOfMonth()));
        assertThat(4, is(testBook.getPublishDate().getMonthValue()));
        assertThat(1992, is(testBook.getPublishDate().getYear()));
        assertThat(5, is(testBook.getRating()));
    }

    @Test
    public void shouldTransformInString() {
        String bookString = testBook.toString();

        assertTrue(bookString.contains("Test Title"));
        assertTrue(bookString.contains("Test Author"));
        assertTrue(bookString.contains("Test Category"));
        assertTrue(bookString.contains("13/04/1992"));
        assertTrue(bookString.contains("5"));
    }
}