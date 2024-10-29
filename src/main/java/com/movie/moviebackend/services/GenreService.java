package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.GenreDto;
import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreRepository repos;
    private final MovieService movieService;
    public GenreService(GenreRepository repos, MovieService movieService) {
        this.repos = repos;
        this.movieService = movieService;
    }
    public GenreDto addNewGenre(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setName(genreDto.name);

        // Save the genre entity
        Genre savedGenre = repos.save(genre);

        // Convert the saved entity back to DTO for response
        return genreToDto(savedGenre);
    }



    // Method to get all movies associated with a specific genre
    public Set<MovieDto> getMoviesByGenre(String genreName) {
       Set<Movie> listMovies =  repos.findMoviesByGenreName(genreName);
        return movieService.setMovieDto(listMovies);
    }

    //Mapping function to retrieve a genre object and map to a GenreDto object
    public GenreDto genreToDto(Genre genre) {
        GenreDto genreDto = new GenreDto();
        genreDto.name = genre.getName();
        genreDto.id = genre.getId();
        return genreDto;
    }
    // Mapping Dto To Genre
    public Genre DtoToGenre(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setId(genreDto.id);
        genre.setName(genreDto.name);
        return genre;
    }

    // Method to get a list of all genres
    public List<GenreDto> getAllGenres() {
        List<Genre> genres = repos.findAll(); // Fetch all genres from the repository
        return genres.stream()
                .map(this::genreToDto) // Convert each Genre to GenreDto
                .collect(Collectors.toList()); // Collect results into a List
    }
}
