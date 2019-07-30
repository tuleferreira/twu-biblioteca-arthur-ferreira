package com.twu.biblioteca.users;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User("Name", "test@gmail.com", "(51) 11111-2222", "123-4567", "testpass123");
    }

    @Test
    public void checkProperties() {
        assertThat(user.getName(), is("Name"));
        assertThat(user.getEmail(), is("test@gmail.com"));
        assertThat(user.getPhone(), is("(51) 11111-2222"));
        assertThat(user.getLibraryNumber(), is("123-4567"));
    }

    @Test
    public void shouldAuthenticate() {
        assertTrue(user.loginAuthentication("testpass123"));
    }

    @Test
    public void shouldFailAuthentication() {
        assertFalse(user.loginAuthentication("wrongpass"));
    }

    @Test
    public void toStringTest() {
        assertThat(user.toString(), is("LN - 123-4567\n" +
                "Name: Name\n" +
                "Email: test@gmail.com\n" +
                "Phone: (51) 11111-2222"));
    }
}