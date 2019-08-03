package com.twu.biblioteca.users;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginManagerTest {

    private LoginManager manager;

    private final User kendrickLamar = new User(
            "Kendrick Lamar",
            "kendrick.lamar@hotmail.com",
            "9999999",
            "123-4567",
            "lam@r"
    );

    @Before
    public void setUp() {
        manager = new LoginManager(singletonList(kendrickLamar));
    }

    @Test
    public void library_number_serves_as_user_identifier() {
        assertThat(manager.identifyUserByLibraryNumber("123-4567"), is(Optional.of(kendrickLamar)));
        assertThat(manager.identifyUserByLibraryNumber("bla bla"), is(Optional.empty()));
    }
}