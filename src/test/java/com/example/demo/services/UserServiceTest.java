package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername("John");
        user.setPassword("1234");
        System.out.println("Initial user: " + user);
        userService.saveUser(user);
    }

    @AfterEach
    public void tearDown() {
        userRepository.delete(user);
    }

    @Test
    @DisplayName("Password encryption is correct")
    public void passwordEncryption() {
        assertTrue(user.getPassword().startsWith("$2a$"));
        System.out.println("Created user: " + user);
    }

    @Test
    @DisplayName("Password is correct")
    public void passwordIsCorrect() {
        boolean isCorrect = userService.checkPassword(user, "1234");
        assertTrue(isCorrect);
        System.out.println("Is the password correct? " + isCorrect);
    }
}
