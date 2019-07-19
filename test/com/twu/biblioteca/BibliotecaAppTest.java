package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void checkWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", BibliotecaApp.welcomeMessage);
    }
}