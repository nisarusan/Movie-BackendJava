package com.movie.moviebackend.dtos;

import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.models.Rating;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MovieDto {
    public Long id;
    public String title;
    public String imageUrl;
    public String director;
    public LocalDate releaseDate;
    public Set<Genre> genres = new HashSet<>();
    public String description;
    public int duration;
    //ratings of users
    public Set<Rating> ratings = new HashSet<>();

}
