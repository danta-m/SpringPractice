package com.example.demo.service;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.DTO.SessionDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.mapper.SessionMapper;
import com.example.demo.model.Movie;
import com.example.demo.model.Session;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.SessionRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Builder

public class SessionService {
    @Autowired
    private final SessionRepository sessionRepository;
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final SessionMapper sessionDto;

    public Session addSession(Session session) {
        Session save = sessionRepository.save(session);
        return save;
    }

    public SessionDTO addSessionDto(Session session) {
        Session save = sessionRepository.save(session);
        return sessionDto.mapToDto(save);
    }

    public void addMovieToSession (Session session, long id) {
        Movie movieById = movieRepository.getById(id);
        session.setMovie(movieById);
        sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public List<SessionDTO> getAllSessionsDto() {
        return sessionRepository.findAll().stream()
                .map(sessionDto::mapToDto)
                .collect(Collectors.toList());
    }

    public Session getSessionByIdDto (Long id) {
        Optional<Session> byId = sessionRepository.findById(id);
        return byId.orElseGet(Session::new);
    }

    public boolean deleteSession (Long id) {
        sessionRepository.deleteById(id);
        return true;
    }

    public Stream<LocalDateTime> findSessionCurrentDay () {
        List<Session> sessions = sessionRepository.findAll();
        LocalDateTime currentDateStart = LocalDateTime.now().with(LocalDateTime.MIN);
        LocalDateTime currentDateEnd = LocalDateTime.now().with(LocalDateTime.MAX);

        return sessions.stream()
                .map(Session::getTime)
                .filter(d -> d.compareTo(currentDateStart) < 0 && d.compareTo(currentDateEnd) > 0);
    }
}

//    List<Movie> movies = new ArrayList<>();
//    Map<Movie, Integer> map = new HashMap<>();
//        for (Movie movie : movies) {
//                map.merge(movie, 1, (prev, one) -> prev + one); //решение нашла , но нужно ли вместо one ставить 1
//                }
//
//        куда это?)))) Мне кажется в добавление фильма в сессию. но у Ромы в сессия сегодняшнего дня