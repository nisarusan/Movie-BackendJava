package com.movie.moviebackend.repositories;

import com.movie.moviebackend.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
