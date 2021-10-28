package com.example.demo.mapper;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements Mapper<MovieDTO, Movie> {
    @Override
    public MovieDTO mapToDto(Movie movie) {
        MovieDTO movieDTO =new MovieDTO();
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setSessionDto(movieDTO.getSessionDto());
        return movieDTO;
    }
}
