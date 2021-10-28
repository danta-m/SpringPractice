package com.example.demo.controller;

import com.example.demo.DTO.SessionDTO;
import com.example.demo.model.Session;
import com.example.demo.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/sessions")
@AllArgsConstructor
public class ControllerSession {
    private final SessionService sessionService;

    @PostMapping("/add")
    public Session addSession(@RequestBody Session session) {
        return sessionService.addSession(session);
    }

    @PostMapping("/addDto")
    public SessionDTO addSessionDto(@RequestBody Session session) {
        return sessionService.addSessionDto(session);
    }

    @GetMapping("/all")
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/get/{id}")
    public Session findSessionById(@PathVariable Long id) {
        return sessionService.getSessionByIdDto(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteSession(@PathVariable Long id) {
        return sessionService.deleteSession(id);
    }

    @PostMapping("/addMovieToSession/{id}")
    public void addMovieToSession (@PathVariable Session session, @PathVariable long id) {
        sessionService.addMovieToSession(session, id);
    }

    @GetMapping("/findSessionCurrentDay")
    public Stream<LocalDateTime> findSessionCurrentDay () {
        return sessionService.findSessionCurrentDay();
    }
}
