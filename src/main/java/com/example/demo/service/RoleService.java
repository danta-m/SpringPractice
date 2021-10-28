package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public Role addRole(Role role) {
        Role save = roleRepository.save(role);
        return save;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById (Long id) {
        Optional<Role> byId = roleRepository.findById(id);
        return byId.orElseGet(Role::new);
    }

    public boolean deleteRole (Long id) {
        roleRepository.deleteById(id);
        return true;
    }
}
