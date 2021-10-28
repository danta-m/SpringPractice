package com.example.demo.controller;

import com.example.demo.DTO.MovieDTO;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor

public class ControllerMovies {

    private final MovieService movieService;

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/get/{id}")
    public Movie findUserById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping("/allDto")
    public List<MovieDTO> getAllMovieDto() {
        return movieService.getAllMovieDto();
    }

    @GetMapping("/getDto/{id}")
    public MovieDTO getMovieByIdDto(@PathVariable Long id) {
        return movieService.getMovieByIdDto(id);
    }
}
