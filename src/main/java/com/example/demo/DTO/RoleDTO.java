package com.example.demo.DTO;

import lombok.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return roleName.equals(roleDTO.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}
