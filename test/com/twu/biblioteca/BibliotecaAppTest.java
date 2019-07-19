package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void checkWelcomeMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        BibliotecaApp.main(new String[]{"a"});
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", outContent.toString().split("\n")[0]);
        System.setOut(null);
    }
}