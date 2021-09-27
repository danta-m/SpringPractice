package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String login;
    private String password;
    private long age;
    private String birthdayDate;

    @ManyToOne (cascade = CascadeType.ALL)
    private Session session;
}
