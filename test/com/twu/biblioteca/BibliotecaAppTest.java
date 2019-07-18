package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void main() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        BibliotecaApp.main();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore\n", outContent.toString());
        System.setOut(null);
    }
}