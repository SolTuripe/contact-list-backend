package com.contactlist.fullstackbackend.service;

import com.contactlist.fullstackbackend.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User updateUser(User newUser, Long id);
    public boolean deleteUser(Long id);
}
