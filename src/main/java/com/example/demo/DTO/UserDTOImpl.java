package com.example.demo.DTO;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOImpl implements UserDTOInt{
    @Override
    public UserDTO mapToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setLogin(user.getLogin());
        return dto;
    }

    @Override
    public User dtoToUser (UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setLogin(dto.getLogin());
        return user;
    }
}
