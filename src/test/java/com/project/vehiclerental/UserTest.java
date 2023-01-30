package com.project.vehiclerental;

import com.project.vehiclerental.entity.User;
import com.project.vehiclerental.enums.Gender;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserBuilder() {
        User user = User.builder()
                .username("testuser")
                .name("Test User")
                .email("test@example.com")
                .password("password123")
                .phoneNumber("1234567890")
                .gender(Gender.MALE)
                .build();

        assertEquals("testuser", user.getUsername());
        assertEquals("Test User", user.getName());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("1234567890", user.getPhoneNumber());
        assertEquals(Gender.MALE, user.getGender());
    }

    @Test
    public void testUserEquality() {
        User user1 = User.builder()
                .id(1L)
                .username("testuser")
                .build();
        User user2 = User.builder()
                .id(1L)
                .username("testuser")
                .build();

        assertEquals(user1, user2);
    }

}
