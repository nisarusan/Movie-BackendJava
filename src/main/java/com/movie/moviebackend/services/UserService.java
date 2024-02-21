package com.movie.moviebackend.services;
import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.dtos.UserDto;
import com.movie.moviebackend.exceptions.RecordNotFoundException;
import com.movie.moviebackend.models.Authority;
import com.movie.moviebackend.models.Movie;
import com.movie.moviebackend.models.Rating;
import com.movie.moviebackend.models.User;
import com.movie.moviebackend.repositories.MovieRepository;
import com.movie.moviebackend.repositories.UserRepository;
import com.movie.moviebackend.utils.RandomStringGenerator;
import io.micrometer.common.util.StringUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MovieService movieService;
    private final MovieRepository movieRepository;
//    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, MovieService movieService, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieService = movieService;
        this.movieRepository = movieRepository;
//        this.passwordEncoder = passwordEncoder;
    }


    //Get specific User by String
    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }


    //Get All the users
    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }


//    Userexist
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }


    //Create User
    public String createUser(UserDto userDto) {
        if (StringUtils.isBlank(userDto.username) || StringUtils.isBlank(userDto.password) || StringUtils.isBlank(userDto.email)) {
            throw new RuntimeException("Username, password, or email cannot be empty.");
        }
//
        // Check if a user with the given username already exists
        if (userRepository.findByUsername(userDto.username) != null) {
            throw new RuntimeException("User with the username already exists.");
        }
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        // Encrypt the password before saving the user
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    //Delete user by String
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    //Get authority of user by String username
    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    //Add authority user by string
    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    //Remove the authority of user by string and role
    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    //User Rate a movie
    public void rateMovie(String username, Long movieId, double rating) {
        User existingUser = userRepository.findById(username).orElse(null);
        Movie existingMovie = movieService.getMovieById(movieId);

        if (existingUser != null && existingMovie != null) {
            // Check if the user has already rated the movie
            if (existingUser.getMoviesRated().stream().anyMatch(movie -> movie.getId().equals(movieId))) {
                throw new RuntimeException("User has already rated this movie.");
            }
            // Create a new Rating entity
            Rating newRating = new Rating();
            newRating.setUser(existingUser);
            newRating.setMovie(existingMovie);
            newRating.setRating(rating);

            // Add the new rating to the user's set of rated movies
            existingUser.getMoviesRated().add(existingMovie);
//            existingUser.getRatings().add(newRating);
            // Save the changes
            userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User or Movie not found with provided IDs.");
        }
    }


    //Set favorite movie for user
    public void setFavoriteMovie(String userName, String movieTitle) {
        // Fetch the user by username from the repository
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            // Handle the case where the user is not found
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }

        // Find the movie by title
        Movie movie = movieRepository.findByTitle(movieTitle);
//
//        if (movie == null) {
//            // Handle the case where the movie is not found
//            throw new MovieNotFoundException("Movie not found with title: " + movieTitle);
//        }

        // Add the movie to the user's favorite movies
        user.getFavoriteMovie().add(movie);

        // Save the updated user in the repository
        userRepository.save(user);
    }

    private Movie mapToMovieEntity(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.id);
        movie.setTitle(movieDto.title);
        // Map other fields as needed
        return movie;
    }

    // Get favorite movies for a user
    public Set<MovieDto> getUserFavoriteMovies(String userName) {
        User existingUser = userRepository.findById(userName).orElse(null);

        if (existingUser != null) {
            // Map the favorite movies to MovieDto
            return existingUser.getFavoriteMovie().stream()
                    .map(movieService::movieDto)
                    .collect(Collectors.toSet());
        } else {
            throw new RuntimeException("User not found with ID: " + userName);
        }
    }

    //User to Dto mapping;
    public static UserDto fromUser(User user){

        var dto = new UserDto();
        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();
        dto.profileUrl = user.getProfileUrl();
        dto.address = user.getAddress();
        dto.moviesSeen = user.getMoviesSeen();
        dto.moviesRated = user.getMoviesRated();
        dto.favoriteMovie = user.getFavoriteMovie();
        return dto;
    }

    //Dto To User mapper;
    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());
        user.setEmail(userDto.getEmail());
        user.setProfileUrl(userDto.getProfileUrl());
        user.setMoviesRated(userDto.getMoviesRated());
        user.setFavoriteMovie(userDto.getFavoriteMovie());
        user.setMoviesSeen(userDto.getMoviesSeen());
        return user;
    }

}
