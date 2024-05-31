package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.GenreDto;
import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.repositories.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenreServiceTest {
    @Mock
    private GenreRepository genreRepository;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private GenreService genreService;

    Genre genre;
    GenreDto genreDto;

    @BeforeEach
    void setUp() {
        genre = new Genre();
        genre.setId(1L);
        genre.setName("Action");

        genreDto = new GenreDto();
        genreDto.id = 1L;
        genreDto.name = "Action";
    }


    @Test
    @DisplayName("Test addNewGenre")
    void testAddNewGenre() {
        when(genreRepository.save(any(Genre.class))).thenReturn(genre);

        GenreDto result = genreService.addNewGenre(genreDto);

        assertEquals(genreDto.name, result.name);
        assertEquals(genreDto.id, result.id);
    }

    @Test
    @DisplayName("Test getMoviesByGenre")
    void testGetMoviesByGenre() {
        String genreName = "Action";
        Set<Movie> movies = new HashSet<>();
        movies.add(new Movie());
        movies.add(new Movie());

        when(genreRepository.findMoviesByGenreName(genreName)).thenReturn(movies);

        Set<MovieDto> movieDtos = new HashSet<>();
        movieDtos.add(new MovieDto());
        movieDtos.add(new MovieDto());

        when(movieService.setMovieDto(movies)).thenReturn(movieDtos);

        Set<MovieDto> result = genreService.getMoviesByGenre(genreName);

        assertEquals(movieDtos.size(), result.size());
    }
}