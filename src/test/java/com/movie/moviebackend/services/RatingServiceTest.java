package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.RatingDto;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.models.User;
import com.movie.moviebackend.repositories.MovieRepository;
import com.movie.moviebackend.repositories.RatingRepository;
import com.movie.moviebackend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RatingService ratingService;

    Rating rating;
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("testUser");

        rating = new Rating();
        rating.setId(1L);
        rating.setRating(4.5);
        rating.setUser(user);
    }


}
