package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    public List<Movie> getAllBook() {
        return movieRepository.findAll();
    }

    @GetMapping("/details/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}/update")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteMovieById(@PathVariable int id) {
        movieRepository.deleteById(id);
    }


}
