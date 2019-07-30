package com.twu.biblioteca.users;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {
    private Users users;

    @Before
    public void setUp() {
        users = new Users();
    }

    @Test
    public void shouldGetUser() {
        assertNotNull(users.getUser("472-6231"));
        assertNull(users.getUser("123-1231"));
    }

    @Test
    public void shouldLogin() {
        assertTrue(users.login("472-6231", "pass123"));
    }

    @Test
    public void shouldFailLogin() {
        assertFalse(users.login("213-2131", "pass123"));
        assertFalse(users.login("472-6231", "123pass"));
    }
}