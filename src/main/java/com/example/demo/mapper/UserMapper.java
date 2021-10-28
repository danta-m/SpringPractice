package com.example.demo.mapper;

import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<UserDTO, User> {
    @Autowired
    private RoleMapper roleDTO;
    @Autowired
    private TicketMapper ticketDTO;

    @Override
    public UserDTO mapToDto (User user) {
                return UserDTO.builder()
                .login(user.getLogin())
                .roleDTOList(user.getRole().stream()
                        .map(role -> roleDTO.mapToDto(role))
                        .collect(Collectors.toList()))
                .ticketDTOList(user.getTickets().stream()
                        .map(ticket -> ticketDTO.mapToDto(ticket))
                        .collect(Collectors.toList()))
                .build();
    }
}
