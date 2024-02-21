package com.movie.moviebackend.controllers;


import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.dtos.UserDto;
import com.movie.moviebackend.exceptions.BadRequestException;
import com.movie.moviebackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    //Get all Users
    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    //Get User by String path: /users/username
    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {

        UserDto optionalUser = userService.getUser(username);


        return ResponseEntity.ok().body(optionalUser);

    }

    //Create User
    @PostMapping(value = "")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {;
        // Encrypt the password before creating the user
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        String newUsername = userService.createUser(dto);
        userService.addAuthority(newUsername, "ROLE_USER");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();
        return ResponseEntity.created(location).body(dto);
    }


    //Update User by string username & Path: user/username
    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UserDto dto) {

        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }


    //Delete User by Username Only accessible by role ADMIN
    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    //Get Request authorities of user
    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    //Post Update Authority of username
    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    //Delete Authority of user
    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }

    //Set the Favorite Movies
    @PostMapping("/{username}/favoritemovies")
    public ResponseEntity<Void> addFavoriteMovie(
            @PathVariable String username,
            @RequestBody MovieDto movieDto) {
        userService.setFavoriteMovie(username, movieDto.title);
        return ResponseEntity.ok().build();
    }

    //Get the Favorite Movie List of User

    @GetMapping("/{username}/favoritemovies")
    public ResponseEntity<Set<MovieDto>> getUserFavoriteMovies(@PathVariable String username) {
        // Call the service method to retrieve the user's favorite movies
        Set<MovieDto> favoriteMovies = userService.getUserFavoriteMovies(username);

        // Check if the user exists
        if (favoriteMovies != null) {
            return ResponseEntity.ok(favoriteMovies);
        } else {
            // Return 404 Not Found if the user is not found
            return ResponseEntity.notFound().build();
        }
    }

}