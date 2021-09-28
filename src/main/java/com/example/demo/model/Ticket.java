package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Ticket")
@Getter
@Setter

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User users;

    @ManyToOne
    @JoinColumn (name = "session_id")
    private Session sessions;
}
