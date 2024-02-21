package com.movie.moviebackend.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    // Deze eerste 3 variabelen zijn verplicht om te kunnen inloggen met een username, password en rol.
    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;


    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    // Deze 3 variabelen zijn niet verplicht.
    // Je mag ook een "String banaan;" toevoegen, als je dat graag wilt.
    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String email;

    @Column
    private String address;

    //this gonna be the bearer token
    @Column
    private String apikey;

    @Column(name = "profile_url")
    private String profileUrl;



    @Column(name = "movies_rated")
    @OneToMany
    private Set<Movie> moviesRated = new HashSet<>();

    @Column(name = "movie_seen")
    @OneToMany
    private Set<Movie> moviesSeen = new HashSet<>();

    @Column(name = "favorite_movie")
    @OneToMany
    private Set<Movie> favoriteMovie = new HashSet<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public Set<Movie> getMoviesRated() {
        return moviesRated;
    }

    public void setMoviesRated(Set<Movie> moviesRated) {
        this.moviesRated = moviesRated;
    }

    public Set<Movie> getMoviesSeen() {
        return moviesSeen;
    }

    public void setMoviesSeen(Set<Movie> moviesSeen) {
        this.moviesSeen = moviesSeen;
    }

    public Set<Movie> getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(Set<Movie> favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }
}