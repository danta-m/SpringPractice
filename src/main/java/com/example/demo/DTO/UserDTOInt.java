package com.example.demo.DTO;

import com.example.demo.model.User;

public interface UserDTOInt {
    UserDTO mapToDto (User user);
    User dtoToUser (UserDTO dto);
}
