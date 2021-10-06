package com.example.userapp.repository;

import com.example.userapp.domain.User;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String DEFAULT_EMAIL = "default.email@mail.com";

    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Get user data on valid user id ")
    public void whenValidUserId_thenUserShouldFond() throws UserNotFoundException {
        Long userId = 1L;
        User user = new User(1L, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL);
        User found = userRepository.getById(user.getId());
        assertEquals(userId, found.getId());

    }
}