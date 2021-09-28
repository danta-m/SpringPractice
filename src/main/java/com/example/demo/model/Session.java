package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "Session")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "session_id")
    private long id;

    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "title")
    private Set<Movie> movies;

    @Column (name = "session_date")
    private String time;

    @OneToMany (mappedBy = "sessions", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;
}
