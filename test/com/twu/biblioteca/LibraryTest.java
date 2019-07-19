package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library testLibrary;

    @Before
    public void setUp() throws Exception {
        testLibrary = new Library();

        Book testBook = new Book("1", "Test", "Test Author", "Test Category", "Test Description", LocalDate.of(1992, 04, 13), 5);
        Book testBook2 = new Book("2", "Test 2", "Test Author 2", "Test Category 2", "Test Description", LocalDate.of(1993, 04, 13), 2);
        Book testBook3 = new Book("3", "Test 3", "Test Author 3", "Test Category 3", "Test Description", LocalDate.of(1995, 7, 18), 3);

        testLibrary.addBookToList(testBook);
        testLibrary.addBookToList(testBook2);
        testLibrary.addBookToList(testBook3);
    }

    @Test
    public void addBooks() {
        assertEquals(3, testLibrary.getBooksList().size());
    }

    @Test
    public void listBooks() {
        String allBooksList = testLibrary.showBooks();

        assertEquals("Books:\n" +
                "Test - Test Author, published in 13/4/1992 and rated 5. ID: 1\n" +
                "Test 2 - Test Author 2, published in 13/4/1993 and rated 2. ID: 2\n" +
                "Test 3 - Test Author 3, published in 18/7/1995 and rated 3. ID: 3\n", allBooksList);
    }
}