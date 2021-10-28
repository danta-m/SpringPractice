package com.example.demo.service;
import com.example.demo.DTO.UserDTO;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userDto;
    @Autowired
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, UserMapper userDto, RoleMapper roleMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userDto = userDto;
        this.roleRepository = roleRepository;
    }

    public UserDTO addUser(User user) {
//        return userDto.mapToDto(userRepository.save(user));
        roleRepository.saveAll(user.getRole());
        return userDto.mapToDto(userRepository.save(user));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDTO> getAllUsersDto() {
        return userRepository.findAll().stream()
                .map(userDto::mapToDto)
                .collect(Collectors.toList());
    }

    public User getUserById (long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseGet(User::new);
    }

    public UserDTO getUserByIdDto (Long id) {
        return userDto.mapToDto(userRepository.findById(id).orElseGet(User::new));
    }

    public boolean deleteUser (long id) {
        userRepository.deleteById(id);
        return true;
    }

//    public User updateUserById (Long id, User user) {
//        Optional<User> byId = userRepository.findById(id);
//        if(user != null) {
//            user.setLogin(user.getLogin());
//            user.setPassword(user.getPassword());
//            user.setRole(user.getRole());
//            userRepository.save(user);
//            return user;
//        }
//        return null;
//    }
}
