package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "movie_id")
    private long id;
    @Column (name = "title")
    private String title;
    @Column (name = "description")
    private String description;

    @OneToMany (mappedBy = "movie", fetch = FetchType.LAZY)
    private Set<Session> sessions;

}
