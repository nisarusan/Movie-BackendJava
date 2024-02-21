package com.movie.moviebackend.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String genre;

//    @ManyToMany(mappedBy = "genres")
//    private Set<Movie> movies = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movies;

    // Constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }
}
