package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library testLibrary;

    @Before
    public void setUp() throws Exception {
        testLibrary = new Library();
    }

    @Test
    public void addBooks() {
        Book testBook = new Book("1", "Test", "Test Author", "Test Category", "Test Description", new Date(1992, 04, 13), 5);
        Book testBook2 = new Book("2", "Test 2", "Test Author", "Test Category 2", "Test Description", new Date(1992, 04, 13), 5);
        Book testBook3 = new Book("3", "Test 3", "Test Author", "Test Category 3", "Test Description", new Date(1992, 04, 13), 5);

        testLibrary.addBookToList(testBook);
        testLibrary.addBookToList(testBook2);
        testLibrary.addBookToList(testBook3);

        assertEquals(3, testLibrary.getBooksList().size());
    }
}