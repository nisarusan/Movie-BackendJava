package com.movie.moviebackend.dtos;

import com.movie.moviebackend.models.Authority;
import com.movie.moviebackend.models.Movie;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;
    public Set<Authority> authorities;
    public String address;
    public String profileUrl;
    public Set<Movie> moviesRated = new HashSet<>();
    public Set<Movie> moviesSeen = new HashSet<>();
    public Set<Movie> favoriteMovie = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}