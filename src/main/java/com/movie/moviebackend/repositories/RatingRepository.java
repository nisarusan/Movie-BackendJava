package com.movie.moviebackend.repositories;

import com.movie.moviebackend.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByMovie_Id(Long movieId);
}
