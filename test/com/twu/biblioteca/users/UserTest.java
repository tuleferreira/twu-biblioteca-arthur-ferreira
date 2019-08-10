package com.twu.biblioteca.users;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        user = new User(
                "Kendrick Lamar",
                "kendrick.lamar@hotmail.com",
                "9999999",
                "123-4567",
                "lam@r"
        );
    }

    @Test
    public void shouldHashPassword() throws NoSuchFieldException, IllegalAccessException {
        Field password = user.getClass().getDeclaredField("password");
        password.setAccessible(true);
        assertNotEquals(password.get(user), "lam@r");
        assertTrue(password.get(user) instanceof byte[]);
    }

    @Test
    public void checkPasswordMatches() {
        assertTrue(user.passwordMatches("lam@r"));
        assertFalse(user.passwordMatches("wrongpass"));
    }

    @Test
    public void checkToString() {
        assertThat(user.toString(), is(String.format("%s\n%s\n%s\n%s",
                "LN - 123-4567",
                "Name: Kendrick Lamar",
                "Email: kendrick.lamar@hotmail.com",
                "Phone: 9999999"
                )
        ));
    }
}