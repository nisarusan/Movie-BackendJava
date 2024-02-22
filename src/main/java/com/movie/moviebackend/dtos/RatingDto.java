package com.movie.moviebackend.dtos;

import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.User;
import jakarta.persistence.*;

public class RatingDto {
    public Long id;
    public User user;
    public UserDto userDto;
    public Long movieId;
    public double rating;
}
