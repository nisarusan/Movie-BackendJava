package com.movie.moviebackend.services;

import com.movie.moviebackend.dtos.UserDto;
import com.movie.moviebackend.models.Authority;
import com.movie.moviebackend.models.User;
import com.movie.moviebackend.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    User user;
    UserDto userDto;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setEmail("test@example.com");
        user.addAuthority(new Authority("testUser", "ROLE_USER"));

        userDto = new UserDto();
        userDto.setUsername("testUser");
        userDto.setPassword("testPassword");
        userDto.setEmail("test@example.com");
        userDto.setAuthorities(Set.of(new Authority("testUser", "ROLE_USER")));
    }

    @Test
    @DisplayName("UserDto terug geven")
    void getUserTest() {
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));

        UserDto result = userService.getUser("testUser");

        assertEquals("testUser", result.getUsername());
        assertEquals("testPassword", result.getPassword());
        assertEquals("test@example.com", result.getEmail());
        assertEquals(1, result.getAuthorities().size());
        assertEquals("ROLE_USER", result.getAuthorities().iterator().next().getAuthority());
    }

    @Test
    @DisplayName("Maak nieuwe user aan en geeft true")
    void createUserTest() {
        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userRepository.save(any(User.class))).thenReturn(user);

        //default aangeven
        userDto.setEnabled(true);

        String result = userService.createUser(userDto);

        assertEquals("testUser", result);
    }

    @Test
    @DisplayName("Wachtwoord updaten")
    void updateUserTest() {
        when(userRepository.existsById(anyString())).thenReturn(true);
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        userDto.setPassword("newPassword");

        userService.updateUser("testUser", userDto);

        assertEquals("newPassword", user.getPassword());
    }

    @Test
    @DisplayName("Authority toevoegen aan de user")
    void addAuthorityTest() {
        when(userRepository.existsById(anyString())).thenReturn(true);
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        userService.addAuthority("testUser", "ROLE_ADMIN");

        assertEquals(2, user.getAuthorities().size());
        assertEquals(Set.of("ROLE_USER", "ROLE_ADMIN"), user.getAuthorities().stream()
                .map(Authority::getAuthority).collect(Collectors.toSet()));
    }
}
