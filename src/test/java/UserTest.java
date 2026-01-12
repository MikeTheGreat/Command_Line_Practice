package com.example.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User("john_doe", "john@example.com", 25);
        assertEquals("john_doe", user.getUsername());
        assertEquals("john@example.com", user.getEmail());
    }

    // TODO: Add test for email validation

    @Test
    public void testIsAdult() {
        User adult = new User("jane", "jane@example.com", 18);
        assertTrue(adult.isAdult());

        User minor = new User("timmy", "timmy@example.com", 15);
        assertFalse(minor.isAdult());
    }
}
