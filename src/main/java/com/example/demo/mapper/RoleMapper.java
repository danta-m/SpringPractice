package com.example.demo.mapper;

import com.example.demo.DTO.RoleDTO;
import com.example.demo.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements Mapper<RoleDTO, Role> {
    @Override
    public RoleDTO mapToDto(Role role) {
        return RoleDTO.builder()
                .roleName(role.getRoleName().name())
                .build();
    }
}
