package com.example.practice24.services;

import com.example.practice24.models.Role;
import com.example.practice24.models.User;
import com.example.practice24.repositories.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repo;

    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("pswd");
        boolean isUserCreated = service.saveUser(user, "cookie");

        assertTrue(isUserCreated);
        Mockito.doReturn(user)
                .when(repo)
                .findByUsername("user");
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("pswd");
        boolean isUserCreated = service.saveUser(user, "cookie");

        assertTrue(isUserCreated);
        Assertions.assertEquals(user.getRoles().size(), 1);
        assertEquals(user.getUsername(), "user");
        assertEquals(user.getSessionID(), "cookie");
        Mockito.verify(repo, Mockito.times(1)).save(user);

    }
}