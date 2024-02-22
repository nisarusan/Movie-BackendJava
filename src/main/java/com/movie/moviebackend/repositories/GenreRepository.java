package com.movie.moviebackend.repositories;

import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);
    Genre findByName(String name);
    // Find movies associated with a specific genre
    @Query("SELECT g.movies FROM Genre g WHERE g.name = :genreName")
    Set<Movie> findMoviesByGenreName(@Param("genreName") String genreName);


}
