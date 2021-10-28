package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "role_id")
    private long id;
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    @JsonIgnoreProperties("roles")
    private Set<User> user;
    @Column (name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public enum RoleName {
        admin, user, moderator
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return id == role.id && user.equals(role.user) && roleName == role.roleName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, roleName);
    }
}

