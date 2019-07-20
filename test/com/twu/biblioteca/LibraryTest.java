package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library testLibrary;

    @Before
    public void setUp() throws Exception {
        testLibrary = new Library();
    }

    @Test
    public void shouldContainAddedBooks() {
        assertEquals(4, testLibrary.getBooksList().size());
    }

    @Test
    public void shouldShowBooks() {
        String allBooksList = testLibrary.toString();

        assertEquals(5, allBooksList.split("\n").length);
    }
}