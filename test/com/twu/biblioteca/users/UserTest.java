package com.twu.biblioteca.users;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("Name", "test@gmail.com", "123-4567", "testpass123");
    }

    @Test
    public void checkProperties() {
        assertThat("Name", is(user.getName()));
        assertThat("test@gmail.com", is(user.getEmail()));
        assertThat("123-4567", is(user.getLibraryNumber()));
    }

    @Test
    public void shouldAuthenticate() {
        assertTrue(user.loginAuthentication("testpass123"));
    }

    @Test
    public void shouldFailAuthentication() {
        assertFalse(user.loginAuthentication("wrongpass"));
    }
}