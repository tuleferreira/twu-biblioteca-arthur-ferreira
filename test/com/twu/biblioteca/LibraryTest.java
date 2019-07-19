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

        Book testBook = new Book(1, "Test", "Test Author", "Test Category", "Test Description", LocalDate.of(1992, 04, 13), 5);
        Book testBook2 = new Book(2, "Test 2", "Test Author 2", "Test Category 2", "Test Description", LocalDate.of(1993, 04, 13), 2);
        Book testBook3 = new Book(3, "Test 3", "Test Author 3", "Test Category 3", "Test Description", LocalDate.of(1995, 7, 18), 3);

        testLibrary.addBookToList(testBook);
        testLibrary.addBookToList(testBook2);
        testLibrary.addBookToList(testBook3);
    }

    @Test
    public void shouldContainAddedBooks() {
        assertEquals(3, testLibrary.getBooksList().size());
    }

    @Test
    public void shouldShowBooks() {
        String allBooksList = testLibrary.showBooks();

        assertEquals(4, allBooksList.split("\n").length);
    }
}