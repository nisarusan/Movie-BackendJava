package com.movie.moviebackend.controllers;

import com.movie.moviebackend.dtos.GenreDto;
import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.services.GenreService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
public class GenreController {

    public GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    public ResponseEntity<GenreDto> addGenre(@RequestBody GenreDto genreDto) {
        GenreDto savedGenreDto = service.addNewGenre(genreDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + savedGenreDto.id).toUriString());
        return ResponseEntity.created(uri).body(savedGenreDto);
    }
    @GetMapping("/movies-by-genre")
    public ResponseEntity<Set<MovieDto>> getMoviesByGenre(@RequestParam String genre) {
        Set<MovieDto> movies = service.getMoviesByGenre(genre);
        return ResponseEntity.ok().body(movies);
    }
}
