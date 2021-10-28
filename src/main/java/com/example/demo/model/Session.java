package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
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

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "movie_session",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")})
    private Movie movie;

    @Column (name = "session_date")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime time;

    @OneToMany (mappedBy = "sessions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return id == session.id && movie.equals(session.movie) && time.equals(session.time) && tickets.equals(session.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, time, tickets);
    }
}
