package com.movie.moviebackend.controllers;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.models.User;
import com.movie.moviebackend.services.MovieService;
import com.movie.moviebackend.services.RatingService;
import com.movie.moviebackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class RatingController {

    public final RatingService ratingService;
    public final MovieService movieService;

    public RatingController(RatingService ratingService, MovieService movieService) {
        this.ratingService = ratingService;
        this.movieService = movieService;
    }

    //set a rating of a movie by user
    @PostMapping("/{userId}/rate-movie/{movieId}")
    public ResponseEntity<Object> rateMovie(@PathVariable String userId, @PathVariable Long movieId, @RequestParam double rating) {
        //Call the service method to set the rating;
        ratingService.rateMovie(userId, movieId, rating);
        return ResponseEntity.ok().body("U heeft een rating geplaatst deze film!");
    }

    //Get the average grade of a single movie made by users works
    @GetMapping("/movie/{movieId}/average-rating")
    public ResponseEntity<Double> getAverageRatingForMovie(@PathVariable Long movieId) {
        return ratingService.getAverageRatingForMovie(movieId);
    }



    //All Rated movies by User
    @GetMapping("/{username}/rated-movies")
    public ResponseEntity<Set<MovieDto>> getRatedMoviesByUsername(@PathVariable String username) {
        try {
            Set<MovieDto> ratedMovies = ratingService.getRatedMoviesByUsername(username);
            return ResponseEntity.ok(ratedMovies);
        } catch (RuntimeException e) {
            // Handle exception, e.g., user not found or other business logic errors
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
