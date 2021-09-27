package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControllerUsers {

    private final UserService userService;

    public ControllerUsers(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/allDto")
    public List<UserDTO> getAllUsersDto() {
        return userService.getAllUsersDto();
    }

    @GetMapping("/get/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getDto/{id}")
    public UserDTO getUserByIdDto(@PathVariable Long id) {
        return userService.getUserByIdDto(id);
    }


    @GetMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/update/{id}")
    public User updateUserById (@PathVariable Long id, @PathVariable User user) {
        return userService.updateUserById(id, user);
    }
}
