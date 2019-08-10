package com.twu.biblioteca;

import com.twu.biblioteca.products.Book;
import com.twu.biblioteca.products.BookParser;
import com.twu.biblioteca.products.Parser;
import com.twu.biblioteca.users.LoginManager;
import com.twu.biblioteca.users.User;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private Field WELCOME_MESSAGE;
    private Method login;
    private Method parseTxt;

    private final User kendrickLamar = new User(
            "Kendrick Lamar",
            "kendrick.lamar@hotmail.com",
            "9999999",
            "123-4567",
            "lam@r"
    );

    private LoginManager loginManager = new LoginManager(
            Collections.singletonList(kendrickLamar)
    );

    @Before
    public void setUp() throws Exception {
        Constructor<?> constructor = BibliotecaApp.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        bibliotecaApp = (BibliotecaApp) constructor.newInstance(loginManager);

        WELCOME_MESSAGE = bibliotecaApp.getClass().getDeclaredField("WELCOME_MESSAGE");
        WELCOME_MESSAGE.setAccessible(true);

        login = bibliotecaApp.getClass().getDeclaredMethod("login", String.class, String.class);
        login.setAccessible(true);

        parseTxt = bibliotecaApp.getClass().getDeclaredMethod("parseTxt", String.class, Parser.class);
        parseTxt.setAccessible(true);
    }

    @Test
    public void checkWelcomeMessage() throws IllegalAccessException {
        assertThat(WELCOME_MESSAGE.get(bibliotecaApp), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore"));
    }

    @Test
    public void shouldLogin() throws InvocationTargetException, IllegalAccessException {
        assertThat(login.invoke(bibliotecaApp, "123-4567", "lam@r"), is(Optional.of(kendrickLamar)));
    }

    @Test
    public void shouldNotLogin() throws InvocationTargetException, IllegalAccessException {
        assertThat(login.invoke(bibliotecaApp, "wrong", "wrong"), is(Optional.empty()));
        assertThat(login.invoke(bibliotecaApp, "123-4567", "wrong"), is(Optional.empty()));
        assertThat(login.invoke(bibliotecaApp, "wrong", "lam@r"), is(Optional.empty()));
    }


    @Test
    public void shouldParseTxt() throws InvocationTargetException, IllegalAccessException {
        List<?> result = (List<?>) parseTxt.invoke(bibliotecaApp, "./test/books.csv", new BookParser());
        assertThat(result.size(), is(4));
        assertTrue(result.get(0) instanceof Book);
    }
}