package com.thoughtworks.library.controller;

import com.thoughtworks.library.model.User;
import com.thoughtworks.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User findUserById(@PathVariable("id") Integer userId) {
        return userService.findUserById(userId);
    }

    @RequestMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}