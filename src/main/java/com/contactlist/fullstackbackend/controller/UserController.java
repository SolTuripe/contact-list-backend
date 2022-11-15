package com.contactlist.fullstackbackend.controller;

import com.contactlist.fullstackbackend.exception.UserNotFoundException;
import com.contactlist.fullstackbackend.model.User;
import com.contactlist.fullstackbackend.repository.UserRepository;
import com.contactlist.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "new contact is add";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with id " + id + " has been deleted successfully";
    }
}
