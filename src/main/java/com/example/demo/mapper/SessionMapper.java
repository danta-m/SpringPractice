package com.example.demo.mapper;

import com.example.demo.DTO.SessionDTO;
import com.example.demo.model.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper implements Mapper<SessionDTO, Session> {
        @Override
        public SessionDTO mapToDto(Session session) {
                SessionDTO sessionDto =new SessionDTO();
                sessionDto.setMoviesDto(sessionDto.getMoviesDto());
                sessionDto.setTime(sessionDto.getTime());
                return sessionDto;
        }
}
