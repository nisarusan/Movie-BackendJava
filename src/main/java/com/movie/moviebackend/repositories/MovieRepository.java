package com.movie.moviebackend.repositories;

import com.movie.moviebackend.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);

    List<Movie> findByTitleIgnoreCase(String title);
}
