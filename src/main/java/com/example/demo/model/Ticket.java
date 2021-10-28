package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table (name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ticket_id")
    private long id;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User users;

    @ManyToOne
    @JoinColumn (name = "session_id")
    private Session sessions;

    @Column (name = "price")
    private double price;
}
