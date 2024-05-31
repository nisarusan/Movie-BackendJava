package com.movie.moviebackend.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {


    // instance field maken leeg of lege variablen;
     Movie movie;
     Genre genre;
     Rating rating;



     //Eerst set-up volledige arrange
    @BeforeEach
    public void setUp() {
    //arrange
        movie = new Movie();
        movie.setTitle("Inception");
        movie.setImageUrl("http://example.com/inception.jpg");
        movie.setDirector("Christopher Nolan");
        movie.setReleaseDate(LocalDate.of(2010, 7, 16));
        movie.setDescription("A thief who steals corporate secrets through the use of dream-sharing technology.");
        movie.setDuration(148);

        genre = new Genre();
        genre.setName("Sci-Fi");
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);
        movie.setGenres(genres);

        rating = new Rating();
        rating.setRating(4);
        Set<Rating> ratings = new HashSet<>();
        ratings.add(rating);
        movie.setRatings(ratings);

    }
    //act
    @Test
    @DisplayName("Krijg title film")
    public void testGetTitle() {
        String title = movie.getTitle();
        // Assert
        assertEquals("Inception", title);
    }


    @Test
    @DisplayName("Krijg de URL van de film afbeelding")
    public void testGetImageUrl() {
        // Act
        String imageUrl = movie.getImageUrl();
        // Assert
        assertEquals("http://example.com/inception.jpg", imageUrl);
    }

    @Test
    @DisplayName("Krijg de naam van de regisseur")
    public void testGetDirector() {
        // Act
        String director = movie.getDirector();
        // Assert
        assertEquals("Christopher Nolan", director);
    }

    @Test
    @DisplayName("Krijg de release datum van de film")
    public void testGetReleaseDate() {
        // Act
        LocalDate releaseDate = movie.getReleaseDate();
        // Assert
        assertEquals(LocalDate.of(2010, 7, 16), releaseDate);
    }

    @Test
    @DisplayName("Krijg de beschrijving van de film")
    public void testGetDescription() {
        // Act
        String description = movie.getDescription();
        // Assert
        assertEquals("A thief who steals corporate secrets through the use of dream-sharing technology.", description);
    }

    @Test
    @DisplayName("Krijg de duur van de film")
    public void testGetDuration() {
        // Act
        int duration = movie.getDuration();
        // Assert
        assertEquals(148, duration);
    }

    @Test
    @DisplayName("Krijg de genres van de film")
    public void testGetGenres() {
        // Act
        Set<Genre> genres = movie.getGenres();
        // Assert
        assertTrue(genres.contains(genre));
        assertEquals(1, genres.size());
    }

    @Test
    @DisplayName("Krijg de beoordelingen van de film")
    public void testGetRatings() {
        // Act
        Set<Rating> ratings = movie.getRatings();
        // Assert
        assertTrue(ratings.contains(rating));
        assertEquals(1, ratings.size());
    }


}