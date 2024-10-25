package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.repositories.GenreRepository;
import com.movie.moviebackend.repositories.MovieRepository;
import com.movie.moviebackend.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository repos;
    private final RatingRepository ratingRepos;
    private final GenreRepository genreRepository;

    public MovieService(MovieRepository repos, RatingRepository ratingRepos, GenreRepository genreRepository) {
        this.repos = repos;
        this.ratingRepos = ratingRepos;
        this.genreRepository = genreRepository;

    }

    // Set Genres for Movies, but only possible if u already have movie object
    public MovieDto setGenresForMovie(Long movieId, Set<Genre> genres) {
        Movie existingMovie = repos.findById(movieId).orElse(null);

        if (existingMovie != null) {
            existingMovie.setGenres(genres);
            repos.save(existingMovie);

            // Make it again a movieDto object
            return movieDto(existingMovie);
        } else {
            throw new RuntimeException("Movie not found with ID: " + movieId);
        }
    }





    //add new movies
//    public MovieDto addMovie(MovieDto movieDto) {
//        Movie movie = dtoToMovie(movieDto);
//        movie.setTitle(movieDto.title);
////        movie.setRatings(movieDto.ratings);
//        movie.setRatings(movieDto.ratings);
//        movie.setGenres(movieDto.genres);
//        movie.setDescription(movieDto.description);
//        movie.setReleaseDate(movieDto.releaseDate);
//        movie.setDuration(movieDto.duration);
//        movie.setImageUrl(movieDto.imageUrl);
//        movie.setDirector(movieDto.director);
//        repos.save(movie);
//        movieDto.id = movie.getId();
//        return movieDto;
//    }

    //new proberen
    // Add new movie with handling for genres
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = dtoToMovie(movieDto);

        // Fetch and set only existing genres
        Set<Genre> movieGenres = new HashSet<>();
        for (Genre genre : movieDto.getGenres()) {
            Optional<Genre> existingGenreOptional = genreRepository.findByNameIgnoreCase(genre.getName());
            existingGenreOptional.ifPresent(movieGenres::add); // Add only existing genres
        }

        movie.setGenres(movieGenres);
        movie.setTitle(movieDto.getTitle());
        movie.setRatings(movieDto.getRatings());
        movie.setDescription(movieDto.getDescription());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setDuration(movieDto.getDuration());
        movie.setImageUrl(movieDto.getImageUrl());
        movie.setDirector(movieDto.getDirector());

        // Save movie
        repos.save(movie);
        movieDto.setId(movie.getId());

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

    // Method to retrieve a Movie by ID
    public Movie getMovieById(Long id) {
        Optional<Movie> optionalMovie = repos.findById(id);
        return optionalMovie.orElse(null);
    }


    // Method to retrieve a MovieDto by ID
    public MovieDto getMovieByIdDto(Long id) {
        Optional<Movie> optionalMovie = repos.findById(id);

        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            return movieDto(movie);
        } else {
            return null; // Movie not found by ID, return null
        }
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

    // Movie DTO Mapper For a Set
    public Set<MovieDto> setMovieDto(Set<Movie> movies) {
        Set<MovieDto> movieDtos = new HashSet<>();

        for (Movie movie : movies) {
            MovieDto movieDto = new MovieDto();
            movieDto.id = movie.getId();
            movieDto.ratings = movie.getRatings();
            movieDto.description = movie.getDescription();
            movieDto.genres = movie.getGenres();
            movieDto.director = movie.getDirector();
            movieDto.imageUrl =  movie.getImageUrl();
            movieDto.releaseDate = movie.getReleaseDate();
            movieDto.title = movie.getTitle();
            movieDto.duration = movie.getDuration();
            movieDtos.add(movieDto);
        }

        return movieDtos;
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
