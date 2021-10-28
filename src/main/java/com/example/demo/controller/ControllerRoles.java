package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor

public class ControllerRoles {
    private final RoleService roleService;

    @PostMapping("/add")
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @GetMapping("/all")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/get/{id}")
    public Role findUserById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
}
