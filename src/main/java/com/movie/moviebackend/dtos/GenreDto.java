package com.movie.moviebackend.dtos;


import com.movie.moviebackend.models.Movie;
import jakarta.persistence.*;

public class GenreDto {
    public Long id;
    public String genre;
    public Movie movies;

}
