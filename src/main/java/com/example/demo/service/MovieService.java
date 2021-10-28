package com.example.demo.service;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.mapper.MovieMapper;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final MovieMapper movieDTO;

    public Movie addMovie(Movie movie) {
        Movie save = movieRepository.save(movie);
        return save;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById (Long id) {
        Optional<Movie> byId = movieRepository.findById(id);
        return byId.orElseGet(Movie::new);
    }

    public boolean deleteMovie (Long id) {
        movieRepository.deleteById(id);
        return true;
    }

    public List<MovieDTO> getAllMovieDto() {
        return movieRepository.findAll().stream()
                .map(movieDTO::mapToDto)
                .collect(Collectors.toList());
    }

    public MovieDTO getMovieByIdDto (Long id) {
        return movieDTO.mapToDto(movieRepository.findById(id).orElseGet(Movie::new));
    }
}
