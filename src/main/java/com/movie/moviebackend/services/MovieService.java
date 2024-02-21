package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.repositories.MovieRepository;
import com.movie.moviebackend.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository repos;
    private final RatingRepository ratingRepos;

    public MovieService(MovieRepository repos, RatingRepository ratingRepos) {
        this.repos = repos;
        this.ratingRepos = ratingRepos;

    }

    //add new movies
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = dtoToMovie(movieDto);
        movie.setTitle(movieDto.title);
//        movie.setRatings(movieDto.ratings);
        movie.setRatings(movieDto.ratings);
        movie.setGenres(movieDto.genres);
        movie.setDescription(movieDto.description);
        movie.setReleaseDate(movieDto.releaseDate);
        movie.setDuration(movieDto.duration);
        movie.setImageUrl(movieDto.imageUrl);
        movie.setDirector(movieDto.director);
        repos.save(movie);
        movieDto.id = movie.getId();
        return movieDto;
    }


    //get all Movies
    public List<MovieDto> allMovies() {
        List<Movie> moviesList = repos.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();
        for(Movie movie : moviesList) {
            MovieDto movieDto = movieDto(movie);
            movieDtoList.add(movieDto);
        }
        return movieDtoList;
    }

    // Get Movie by ID
    public Movie getMovieById(Long id) {
        Optional<Movie> optionalMovie = repos.findById(id);
        return optionalMovie.orElse(null);
    }

    //Search Movies by string title
    public List<MovieDto> searchMovies(String title) {
        List<Movie> movies = repos.findByTitleIgnoreCase(title);
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : movies) {
            movieDtos.add(movieDto(movie));
        }
        return movieDtos;
    }

    // Get the average rating for a movie from the Rating table
    public Double getAverageRatingForMovie(Long movieId) {
        List<Rating> ratings = ratingRepos.findByMovie_Id(movieId);

        if (!ratings.isEmpty()) {
            // Calculate the average rating
            double sum = ratings.stream().mapToDouble(Rating::getRating).sum();
            return sum / ratings.size();
        } else {
            // Return null if no ratings are found for the movie
            return null;
        }
    }


    //Movie DTO Mapper
    public MovieDto movieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.id = movie.getId();
        movieDto.ratings = movie.getRatings();
        movieDto.description = movie.getDescription();
        movieDto.genres = movie.getGenres();

//        movieDto.ratings = movie.getRatings();
        movieDto.director = movie.getDirector();
        movieDto.imageUrl = movie.getImageUrl();
        movieDto.releaseDate = movie.getReleaseDate();
        movieDto.title = movie.getTitle();
        movieDto.duration = movie.getDuration();
        return movieDto;
    }


    //Dto To User mapper
    public Movie dtoToMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.title);
//        movie.setRatings(movieDto.ratings);
        movie.setDescription(movieDto.description);
        movie.setDirector(movieDto.director);
        movie.setDuration(movieDto.duration);
        movie.setGenres(movieDto.genres);
        movie.setImageUrl(movieDto.imageUrl);
        movie.setReleaseDate(movieDto.releaseDate);
        return movie;
    }

}
