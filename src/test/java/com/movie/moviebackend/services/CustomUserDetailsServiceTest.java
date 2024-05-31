package com.movie.moviebackend.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.movie.moviebackend.dtos.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.movie.moviebackend.models.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    private UserDto userDto;

    //Arrange alvast


    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setUsername("testUser");
        userDto.setPassword("testPassword");
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority("testUser", "ROLE_USER"));
        userDto.setAuthorities(authorities);
    }

    @Test
    @DisplayName("Load user by username successfully")
    void loadUserByUsernameSuccess() {
        when(userService.getUser(anyString())).thenReturn(userDto);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername("testUser");

        assertEquals(userDto.getUsername(), userDetails.getUsername());
        assertEquals(userDto.getPassword(), userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());
        GrantedAuthority authority = userDetails.getAuthorities().iterator().next();
        assertEquals("ROLE_USER", authority.getAuthority());
    }

}