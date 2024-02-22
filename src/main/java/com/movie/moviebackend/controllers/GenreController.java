package com.movie.moviebackend.controllers;

import com.movie.moviebackend.dtos.GenreDto;
import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.services.GenreService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class GenreController {

    public GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @PostMapping("/add/genre")
    public ResponseEntity<GenreDto> addGenre(@RequestBody GenreDto genreDto) {
        GenreDto savedGenreDto = service.addNewGenre(genreDto);
        return ResponseEntity.ok().body(savedGenreDto);
    }

    @GetMapping("/movies-by-genre")
    public ResponseEntity<Set<MovieDto>> getMoviesByGenre(@RequestParam String genre) {
        Set<MovieDto> movies = service.getMoviesByGenre(genre);
        return ResponseEntity.ok().body(movies);
    }
}
