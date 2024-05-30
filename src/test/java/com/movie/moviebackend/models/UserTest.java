package com.movie.moviebackend.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class UserTest {



    //lege instance field defineren

    private User user;
    private Authority authority;
    private Movie movie;
    private Rating rating;

    @BeforeEach
    public void setUp() {
        // Arrange
        user = new User();
        user.setUsername("testuser");
        user.setPassword("password123");
        user.setEnabled(true);
        user.setEmail("testuser@example.com");
        user.setAddress("123 Test St");
        user.setApikey("apikey123");
        user.setProfileUrl("http://example.com/profile.jpg");

        authority = new Authority();
        authority.setUsername("testuser");
        authority.setAuthority("ROLE_USER");
        user.addAuthority(authority);

        movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");

        Set<Movie> moviesRated = new HashSet<>();
        moviesRated.add(movie);
        user.setMoviesRated(moviesRated);

        Set<Movie> moviesSeen = new HashSet<>();
        moviesSeen.add(movie);
        user.setMoviesSeen(moviesSeen);

        Set<Movie> favoriteMovies = new HashSet<>();
        favoriteMovies.add(movie);
        user.setFavoriteMovie(favoriteMovies);

        rating = new Rating();
        rating.setId(1L);
        rating.setUser(user);
        rating.setMovie(movie);
        rating.setRating(5.0);

        Set<Rating> ratings = new HashSet<>();
        ratings.add(rating);
        user.setRatings(ratings);
    }

    @Test
    @DisplayName("Krijg de gebruikersnaam van de gebruiker")
    public void testGetUsername() {
        // Act
        String username = user.getUsername();
        // Assert
        assertEquals("testuser", username);
    }

}