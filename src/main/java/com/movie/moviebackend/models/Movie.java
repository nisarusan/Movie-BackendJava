package com.movie.moviebackend.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    Long id;

    @Column
    String title;

    @Column(name = "image_url")
    String imageUrl;

    @Column
    String director;


    @Column(name = "release_date")
    LocalDate releaseDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();


//    @Lob
    String description;

    @Column
    int duration;


    //ratings of users
    @OneToMany
    private Set<Rating> ratings = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

//    public Set<Genre> getGenre() {
//        return genres;
//    }
//
//    public void setGenre(Set<Genre> genres) {
//        this.genres = genres;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
    //    public Set<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(Set<Rating> ratings) {
//        this.ratings = ratings;
//    }
}