package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;

    @ManyToMany (cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn (name = "role_name")
    private Set<Role> role;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}
