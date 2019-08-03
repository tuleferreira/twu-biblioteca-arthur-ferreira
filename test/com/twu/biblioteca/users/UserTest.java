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
    public void checkPasswordMatches() {
        assertTrue(user.passwordMatches("testpass123"));
        assertFalse(user.passwordMatches("wrongpass"));
    }

    @Test
    public void checkToString() {
        assertThat(user.toString(), is("LN - 123-4567\n" +
                "Name: Name\n" +
                "Email: test@gmail.com\n" +
                "Phone: (51) 11111-2222"));
    }
}