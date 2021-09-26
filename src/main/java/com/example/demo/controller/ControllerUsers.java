package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControllerUsers {


    private static long id = 1;
    private final UserService userService;

    public ControllerUsers(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/all")
    public List<User> getAllUsers(@RequestBody User user) {
        return userService.getAllUsers();
    }

}
