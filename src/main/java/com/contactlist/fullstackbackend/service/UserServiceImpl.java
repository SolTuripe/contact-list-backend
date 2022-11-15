package com.contactlist.fullstackbackend.service;

import com.contactlist.fullstackbackend.exception.UserNotFoundException;
import com.contactlist.fullstackbackend.model.User;
import com.contactlist.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public User updateUser(User newUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPhoneNumber(newUser.getPhoneNumber());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
