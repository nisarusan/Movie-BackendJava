package com.movie.moviebackend.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {


    //instance field lege definieren
    private Rating rating;
    private User user;
    private Movie movie;

    // Dit is nodig zodat eerst set-up wordt uitgevoerd voor elke testmethode / functie
    @BeforeEach
    public void setUp() {
        // Arrange
        rating = new Rating();
        rating.setRating(4.5);

        user = new User();
        user.setUsername("testuser");
        rating.setUser(user);


        movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");
        rating.setMovie(movie);
    }

    @Test
    @DisplayName("Krijg de ID van de rating")
    public void testGetId() {
        // Act
        rating.setId(1L);
        Long id = rating.getId();

        // Assert verwacht
        assertEquals(1L, id);
}

    @Test
    @DisplayName("Krijg de gebruiker van de rating")
    public void testGetUser() {
        // Act
        User resultUser = rating.getUser();

        // Assert
        assertEquals(user, resultUser);
    }

    @Test
    @DisplayName("Krijg de film van de rating")
    public void testGetMovie() {
        // Act
        Movie resultMovie = rating.getMovie();

        // Assert
        assertEquals(movie, resultMovie);
    }

    @Test
    @DisplayName("Krijg de waarde van de rating")
    public void testGetRating() {
        // Act
        double resultRating = rating.getRating();

        // Assert
        assertEquals(4.5, resultRating);
    }
}