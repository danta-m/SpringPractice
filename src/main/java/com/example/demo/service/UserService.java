package com.example.demo.service;
import com.example.demo.DTO.UserDTO;
import com.example.demo.DTO.UserDTOImpl;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserDTOImpl userDto;

    public UserService(UserRepository userRepository, UserDTOImpl userDto) {
        this.userRepository = userRepository;
        this.userDto = userDto;
    }

    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDTO> getAllUsersDto() {
        return userRepository.findAll().stream()
                .map(userDto::mapToDto)
                .collect(Collectors.toList());
    };
//        return userDto.mapToDto(userRepository.findAll());
//    }

    public User getUserById (long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseGet(User::new);
    }

    public UserDTO getUserByIdDto (Long id) {
        return userDto.mapToDto(userRepository.findById(id).orElseGet(User::new));

    }
//        public User findUserById (long id) {
//        for (User user : userRepository) {
//            if (user.getId() == id ) {
//                return user;
//            }
//        }
//        return new User();
//    }
//
    public boolean deleteUser(long id) {
        userRepository.deleteById(id);
        return true;
    }

}
