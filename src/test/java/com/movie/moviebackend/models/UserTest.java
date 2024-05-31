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

    @Test
    @DisplayName("Krijg het wachtwoord van de gebruiker")
    public void testGetPassword() {
        // Act
        String password = user.getPassword();
        // Assert
        assertEquals("password123", password);
    }


    @Test
    @DisplayName("Krijg de enabled status van de gebruiker")
    public void testIsEnabled() {
        // Act
        boolean enabled = user.isEnabled();
        // Assert
        assertTrue(enabled);
    }

    @Test
    @DisplayName("Krijg de email van de gebruiker")
    public void testGetEmail() {
        // Act
        String email = user.getEmail();
        // Assert
        assertEquals("testuser@example.com", email);
    }

    @Test
    @DisplayName("Krijg de API sleutel van de gebruiker")
    public void testGetApikey() {
        // Act
        String apikey = user.getApikey();
        // Assert
        assertEquals("apikey123", apikey);
    }


    @Test
    @DisplayName("Krijg de profiel URL van de gebruiker")
    public void testGetProfileUrl() {
        // Act
        String profileUrl = user.getProfileUrl();
        // Assert
        assertEquals("http://example.com/profile.jpg", profileUrl);
    }


    @Test
    @DisplayName("Krijg de autoriteiten van de gebruiker")
    public void testGetAuthorities() {
        // Act
        Set<Authority> authorities = user.getAuthorities();
        // Assert
        assertTrue(authorities.contains(authority));
        assertEquals(1, authorities.size());
    }

    @Test
    @DisplayName("Krijg de films die de gebruiker heeft beoordeeld")
    public void testGetMoviesRated() {
        // Act
        Set<Movie> moviesRated = user.getMoviesRated();
        // Assert
        assertTrue(moviesRated.contains(movie));
        assertEquals(1, moviesRated.size());
    }

    @Test
    @DisplayName("Krijg de films die de gebruiker heeft gezien")
    public void testGetMoviesSeen() {
        // Act
        Set<Movie> moviesSeen = user.getMoviesSeen();
        // Assert
        assertTrue(moviesSeen.contains(movie));
        assertEquals(1, moviesSeen.size());
    }
    @Test
    @DisplayName("Krijg de favoriete films van de gebruiker")
    public void testGetFavoriteMovie() {
        // Act
        Set<Movie> favoriteMovies = user.getFavoriteMovie();
        // Assert
        assertTrue(favoriteMovies.contains(movie));
        assertEquals(1, favoriteMovies.size());
    }
    @Test
    @DisplayName("Krijg de beoordelingen van de gebruiker")
    public void testGetRatings() {
        // Act
        Set<Rating> ratings = user.getRatings();
        // Assert
        assertTrue(ratings.contains(rating));
        assertEquals(1, ratings.size());
    }
}