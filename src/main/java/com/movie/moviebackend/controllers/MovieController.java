package com.movie.moviebackend.controllers;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }


    //add new Movies
    @PostMapping("/movie")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        movieDto = service.addMovie(movieDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + movieDto.id).toUriString());
        return ResponseEntity.created(uri).body(movieDto);
    }

    //getAll movies
    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movieDto = service.allMovies();
        return ResponseEntity.ok().body(movieDto);
    }

    //getMovie by Title
    @GetMapping("/movie")
    public ResponseEntity<List<MovieDto>> getMovieByTitle(@RequestParam String title) {
        List<MovieDto> movieDto = service.searchMovies(title);
        if (movieDto != null) {
            return ResponseEntity.ok().body(movieDto);
        } else {
            // Movie not found, return a ResponseEntity with NOT_FOUND status
            return ResponseEntity.notFound().build();
        }
    }

    //Get Movie By ID
    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        MovieDto movieDto = service.getMovieByIdDto(id);

        if (movieDto != null) {
            return ResponseEntity.ok().body(movieDto);
        } else {
            // Movie not found, return a ResponseEntity with NOT_FOUND status
            return ResponseEntity.notFound().build();
        }
    }

    //Set or Add Genre of the movie by ID notworking... Don't know how to fix this.
    @PostMapping("/setgenre/{movieId}")
    public ResponseEntity<MovieDto> setGenresForMovie(@PathVariable Long movieId, @RequestBody Set<Genre> genreNames) {
        MovieDto updatedMovie = service.setGenresForMovie(movieId, genreNames);
        return ResponseEntity.ok().body(updatedMovie);
    }
}


