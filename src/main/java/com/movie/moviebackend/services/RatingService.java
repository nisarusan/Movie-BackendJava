package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.dtos.RatingDto;
import com.movie.moviebackend.dtos.UserDto;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.models.User;
import com.movie.moviebackend.repositories.RatingRepository;
import com.movie.moviebackend.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RatingService {

    public final UserService userService;
    public final RatingRepository repos;
    public final MovieService movieService;
    public final UserRepository userRepos;

    public RatingService(UserService userService, RatingRepository repos, MovieService movieService, UserRepository userRepos) {
        this.userService = userService;
        this.repos = repos;
        this.movieService = movieService;
        this.userRepos = userRepos;
    }

    // User Rate a movie
    public ResponseEntity<String> rateMovie(String username, Long movieId, double rating) {
        User existingUser = userRepos.findById(username).orElse(null);
        Movie existingMovie = movieService.getMovieById(movieId);

        if (existingUser != null && existingMovie != null) {

            // Create a new Rating entity
            Rating newRating = new Rating();
            newRating.setUser(existingUser);
            newRating.setMovie(existingMovie);
            newRating.setRating(rating);

            // Add the new rating to the user's set of rated movies
            existingUser.getRatings().add(newRating);

            // Save the changes
            userRepos.save(existingUser);
        } else {
            throw new RuntimeException("User or Movie not found with provided IDs.");
        }
        return ResponseEntity.ok().body("Added the Rating");
    }


    //get the rating of a movie
    public ResponseEntity<Rating> getRatingOfMovie(String username, Long movieId) {
        User existingUser = userRepos.findById(username).orElse(null);
        Movie existingMovie = movieService.getMovieById(movieId);

        if (existingUser != null && existingMovie != null) {
            Rating existingRating = repos.findByUserAndMovie(existingUser, existingMovie);

            if (existingRating != null) {
                return ResponseEntity.ok().body(existingRating);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all the rated movies list
    public Set<MovieDto> getRatedMoviesByUsername(String username) {
        // Retrieve the user from the repository
        User existingUser = userRepos.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + username));

        // Get the set of ratings for the user
        Set<Rating> userRatings = existingUser.getRatings();

        // Extract the movies from the ratings
        Set<Movie> ratedMovies = userRatings.stream()
                .map(Rating::getMovie)
                .collect(Collectors.toSet());

        // Convert Movie entities to MovieDto objects
        Set<MovieDto> ratedMovieDtos = ratedMovies.stream()
                .map(movieService::movieDto)
                .collect(Collectors.toSet());

        return ratedMovieDtos;
    }

    //Get average rating for a Movie based on all user's input for the movie
    public ResponseEntity<Double> getAverageRatingForMovie(Long movieId) {
        Movie existingMovie = movieService.getMovieById(movieId);

        if (existingMovie != null) {
            List<Rating> ratingsForMovie = repos.findAllByMovie(existingMovie);

            OptionalDouble averageRating = ratingsForMovie.stream()
                    .mapToDouble(Rating::getRating)
                    .average();

            return ResponseEntity.ok().body(averageRating.orElse(0.0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //delete rating of user
    public void deleteRatedMovie(String username, Long movieId) {
        User existingUser = userRepos.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + username));

        if (existingUser == null) {
            throw new RuntimeException("Gebruiker niet gevonden");
        }

        Rating rating = repos.findByUserAndMovie(existingUser, movieService.getMovieById(movieId));
        if (rating == null) {
            throw new RuntimeException("Beoordeling niet gevonden");
        }

        repos.delete(rating);
    }


    // Rating DTO Mapper
    public RatingDto ratingDto(Rating rating) {
        RatingDto ratingDto = new RatingDto();
        ratingDto.id = rating.getId();

        // Check if user is not null before accessing its properties
        if (rating.getUser() != null) {
            ratingDto.userDto = userService.fromUser(rating.getUser());
        }

        ratingDto.movieId = rating.getMovie().getId();
        ratingDto.rating = rating.getRating();
        return ratingDto;
    }

    // DTO To Rating mapper
    public Rating dtoToRating(RatingDto ratingDto) {
        Rating rating = new Rating();
        // Ensure user is not null before accessing its properties
        if (ratingDto.user != null) {
            rating.setUser(userService.toUser(ratingDto.userDto));
        }
        rating.setMovie(movieService.getMovieById(ratingDto.movieId));
        rating.setRating(ratingDto.rating);
        return rating;
    }
}
