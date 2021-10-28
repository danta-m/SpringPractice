package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;

    @ManyToMany (mappedBy = "user", cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private Set<Role> role;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    @JoinTable(name = "user_tickets",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id")})
    private Set<Ticket> tickets;

}
