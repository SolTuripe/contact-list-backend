package com.contactlist.fullstackbackend.service;

import com.contactlist.fullstackbackend.model.User;
import com.contactlist.fullstackbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    void canCreateAUser() {
        User newUser = new User();

        Mockito.when(userRepository.save(newUser)).thenReturn(newUser);

        assertEquals(newUser, userRepository.save(newUser));
    }

    @Test
    void canGetAllUser() {
        var listUsers = List.of(new User(), new User());

        Mockito.when(userRepository.findAll()).thenReturn(listUsers);
        var userService = new UserServiceImpl(userRepository);
        var sut = userService.getAllUsers();

        assertEquals(sut, listUsers);
    }

    @Test
    void canGetAUserById() {
        User user = new User();

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        var userService = new UserServiceImpl(userRepository);
        var sut = userService.getUserById(1L);

        assertEquals(sut, user);
    }
}
