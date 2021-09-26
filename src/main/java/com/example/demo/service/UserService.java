package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById (long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseGet(User::new);
    }
}
