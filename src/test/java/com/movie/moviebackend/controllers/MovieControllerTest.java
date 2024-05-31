package com.movie.moviebackend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.moviebackend.dtos.MovieDto;
import com.movie.moviebackend.models.Genre;
import com.movie.moviebackend.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// not sure why the config doesn't work properly
@ExtendWith(SpringExtension.class)
@WebMvcTest(MovieController.class)
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Autowired
    private ObjectMapper objectMapper;

    private MovieDto movieDto;

    @BeforeEach
    void setUp() {
        movieDto = new MovieDto();
        movieDto.id = 1L;
        movieDto.title = "Test Movie";
    }

    @Test
    @DisplayName("Add new movie")
    void addMovieTest() throws Exception {
        Mockito.when(movieService.addMovie(Mockito.any(MovieDto.class))).thenReturn(movieDto);

        mockMvc.perform(post("/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movieDto)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/movie/1"))
                .andExpect(jsonPath("$.title").value("Test Movie"));
    }
    @Test
    @DisplayName("Get all movies")
    void getAllMoviesTest() throws Exception {
        List<MovieDto> movieList = List.of(movieDto);
        Mockito.when(movieService.allMovies()).thenReturn(movieList);

        mockMvc.perform(get("/movies")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].title").value("Test Movie"));
    }

    @Test
    @DisplayName("Get movie by title")
    void getMovieByTitleTest() throws Exception {
        List<MovieDto> movieList = List.of(movieDto);
        Mockito.when(movieService.searchMovies(Mockito.anyString())).thenReturn(movieList);

        mockMvc.perform(get("/movie")
                        .param("title", "Test Movie")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].title").value("Test Movie"));
    }

    @Test
    @DisplayName("Get movie by ID")
    void getMovieByIdTest() throws Exception {
        Mockito.when(movieService.getMovieByIdDto(Mockito.anyLong())).thenReturn(movieDto);

        mockMvc.perform(get("/movie/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Movie"));
    }

    @Test
    @DisplayName("Set genres for movie")
    void setGenresForMovieTest() throws Exception {
        Set<Genre> genres = new HashSet<>();
        genres.add(new Genre(1L, "Action"));
        movieDto.genres = genres;

        Mockito.when(movieService.setGenresForMovie(Mockito.anyLong(), Mockito.any(Set.class))).thenReturn(movieDto);

        mockMvc.perform(post("/setgenre/{movieId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(genres)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.genres.size()").value(1))
                .andExpect(jsonPath("$.genres[0].name").value("Action"));
    }
}
