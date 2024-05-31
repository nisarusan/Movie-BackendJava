package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.repositories.GenreRepository;
import com.movie.moviebackend.repositories.MovieRepository;
import com.movie.moviebackend.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class MovieServiceTest {
    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private GenreRepository genreRepository;

    @Test
    @DisplayName("Test voegMovie toe")
    void testAddMovie() {
        // Arrange
        MovieDto movieDto = new MovieDto();
        movieDto.setTitle("Test Movie");
        movieDto.setDescription("This is a test movie");
        movieDto.setDirector("Test Director");
        movieDto.setDuration(120);
        Set<Genre> genres = new HashSet<>();
        Genre actionGenre = new Genre();
        actionGenre.setName("Action");
        Genre dramaGenre = new Genre();
        dramaGenre.setName("Drama");
        genres.add(actionGenre);
        genres.add(dramaGenre);
        movieDto.setGenres(genres);
        movieDto.setImageUrl("test.jpg");
        movieDto.setReleaseDate(LocalDate.now());

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Test Movie");
        movie.setDescription("This is a test movie");
        movie.setDirector("Test Director");
        movie.setDuration(120);
        movie.setGenres(genres);
        movie.setImageUrl("test.jpg");
        movie.setReleaseDate(LocalDate.now());

        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        // Act
        MovieDto result = movieService.addMovie(movieDto);

        // Assert
        assertEquals(movieDto.getTitle(), result.getTitle());
        assertEquals(movieDto.getDescription(), result.getDescription());
        assertEquals(movieDto.getDirector(), result.getDirector());
        assertEquals(movieDto.getDuration(), result.getDuration());
        assertEquals(movieDto.getGenres(), result.getGenres());
        assertEquals(movieDto.getImageUrl(), result.getImageUrl());
        assertEquals(movieDto.getReleaseDate(), result.getReleaseDate());
    }
    @Test
    @DisplayName("Test getMovieById")
    void testGetMovieById() {
        // Arrange
        Long movieId = 1L;
        Movie expectedMovie = new Movie();
        // Set expected movie attributes
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(expectedMovie));

        // Act
        Movie result = movieService.getMovieById(movieId);

        // Assert
        assertEquals(expectedMovie, result);
    }


    @Test
    @DisplayName("Test searchMovies methode")
    void testSearchMovies() {
        // Arrange
        String title = "Test Movie";
        List<Movie> expectedMovies = new ArrayList<>();
        // Add expected movies to the list
        when(movieRepository.findByTitleIgnoreCase(title)).thenReturn(expectedMovies);

        // Act
        List<MovieDto> result = movieService.searchMovies(title);

        // Assert
        assertTrue(result.isEmpty());
    }
    @Test
    @DisplayName("Test getAverageRatingForMovie method")
    void testGetAverageRatingForMovie() {
        // Arrange
        Long id = 1L;
        Double expectedRating = 4.5;
        Rating rating = new Rating();
        rating.setRating(expectedRating);

        // Act
        Double actualRating = rating.getRating();

        // Assert
        assertEquals(expectedRating, rating.getRating());
    }

    @Test
    @DisplayName("Test setGenresForMovie method")
    void testSetGenresForMovie() {
        // Arrange
        Long movieId = 1L;
        Set<Genre> genres = new HashSet<>();
        // Add genres to the set
        MovieDto movieDto = new MovieDto();
        // Set movieDto attributes
        Movie existingMovie = new Movie();
        // Set existingMovie attributes
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(existingMovie));

        // Act
        MovieDto result = movieService.setGenresForMovie(movieId, genres);

        // Assert
        assertEquals(genres, result.getGenres());
    }
}