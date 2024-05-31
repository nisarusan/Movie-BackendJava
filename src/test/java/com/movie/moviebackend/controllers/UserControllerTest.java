package com.movie.moviebackend.controllers;

import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.dtos.UserDto;
import com.movie.moviebackend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test getUsers")
    void testGetUsersEndpoint() throws Exception {
        List<UserDto> userDtos = Collections.singletonList(new UserDto());
        when(userService.getUsers()).thenReturn(userDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @DisplayName("Krijg user met get method")
    void getUserTest() {
        UserDto userDto = new UserDto();
        when(userService.getUser(anyString())).thenReturn(userDto);
        ResponseEntity<UserDto> responseEntity = userController.getUser("testUser");
        verify(userService, times(1)).getUser("testUser");
        assert responseEntity.getStatusCode().equals(HttpStatus.OK);
    }

    @Test
    @DisplayName("Maak user aan")
    void createUserTest() {
        UserDto userDto = new UserDto();
        userDto.setUsername("testUser");
        when(userService.createUser(any(UserDto.class))).thenReturn("testUser");
        ResponseEntity<UserDto> responseEntity = userController.createUser(userDto);
        verify(userService, times(1)).createUser(any(UserDto.class));
        assert responseEntity.getStatusCode().equals(HttpStatus.CREATED);
        assert responseEntity.getHeaders().getLocation().toString().contains("/users/testUser");
    }

    @Test
    @DisplayName("Update User")
    void updateUserTest() {
        UserDto userDto = new UserDto();
        userDto.setUsername("testUser");
        ResponseEntity<UserDto> responseEntity = userController.updateUser("testUser", userDto);
        verify(userService, times(1)).updateUser("testUser", userDto);
        assert responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Verwijder user")
    void deleteUserTest() {
        ResponseEntity<Object> responseEntity = userController.deleteUser("testUser");
        verify(userService, times(1)).deleteUser("testUser");
        assert responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Get user authorities")
    void getUserAuthoritiesTest() {
        ResponseEntity<Object> responseEntity = userController.getUserAuthorities("testUser");
        verify(userService, times(1)).getAuthorities("testUser");
        assert responseEntity.getStatusCode().equals(HttpStatus.OK);
    }

    @Test
    @DisplayName("Voeg User Authority")
    void addUserAuthorityTest() {
        ResponseEntity<Object> responseEntity = userController.addUserAuthority("testUser", Collections.singletonMap("authority", "ROLE_ADMIN"));
        verify(userService, times(1)).addAuthority("testUser", "ROLE_ADMIN");
        assert responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Verwijder User Authority")
    void deleteUserAuthorityTest() {
        ResponseEntity<Object> responseEntity = userController.deleteUserAuthority("testUser", "ROLE_ADMIN");
        verify(userService, times(1)).removeAuthority("testUser", "ROLE_ADMIN");
        assert responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("Set User Favorite Movies")
    void setUserFavoriteMoviesTest() {
        ResponseEntity<Void> responseEntity = userController.setUserFavoriteMovies("userId", Collections.singleton(new MovieDto()));
        verify(userService, times(1)).addFavoriteMovies("userId", Collections.singleton(new MovieDto()));
        assert responseEntity.getStatusCode().equals(HttpStatus.OK);
    }

    @Test
    @DisplayName("Get User Favoritie Movies")
    void getUserFavoriteMoviesTest() {
        ResponseEntity<Set<MovieDto>> responseEntity = userController.getUserFavoriteMovies("userId");
        verify(userService, times(1)).getUserFavoriteMovies("userId");
        assert responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Verwijder Favorite Movies")
    void removeFavoriteMoviesTest() {
        ResponseEntity<UserDto> responseEntity = userController.removeFavoriteMovies("userId", Collections.singleton(new MovieDto()));
        verify(userService, times(1)).removeFavoriteMovies("userId", Collections.singleton(new MovieDto()));
        assert responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Set User Seen Movies")
    void setUserSeenMoviesTest() {
        ResponseEntity<Void> responseEntity = userController.setUserSeenMovies("userId", Collections.singleton(new MovieDto()));
        verify(userService, times(1)).addSeenMovies("userId", Collections.singleton(new MovieDto()));
        assert responseEntity.getStatusCode().equals(HttpStatus.OK);
    }

    @Test
    @DisplayName("Get User Seen Movies")
    void getUserSeenMoviesTest() {
        ResponseEntity<Set<MovieDto>> responseEntity = userController.getUserSeenMovies("userId");
        verify(userService, times(1)).getUserSeenMovies("userId");
        assert responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND);
    }

    @Test
    @DisplayName("Verwijder Seen Movies")
    void removeSeenMoviesTest() {
        ResponseEntity<UserDto> responseEntity = userController.removeSeenMovies("userId", Collections.singleton(new MovieDto()));
        verify(userService, times(1)).removeSeenMovies("userId", Collections.singleton(new MovieDto()));
        assert responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND);
    }


}
