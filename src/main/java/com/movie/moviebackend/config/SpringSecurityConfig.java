package com.movie.moviebackend.config;

import com.movie.moviebackend.filter.JwtRequestFilter;
import com.movie.moviebackend.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    public final CustomUserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setUserDetailsService(customUserDetailsService);
        return new ProviderManager(authProvider);
    }

    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth

                        //Wil je alles even testen zonder authorisatie
//                        .anyRequest().permitAll()

                        // Alleen admin-toegang voor het toevoegen van genres
                        .requestMatchers(HttpMethod.POST, "/add/genre").permitAll() //Bug.. kan niet uitvoggelen waarom.. jwt token is correct..

                        // User en admin toegang voor het opvragen van films per genre
                        .requestMatchers(HttpMethod.GET, "/movies-by-genre").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

                        // Toegang voor iedereen tot de authenticatie endpoints
                        .requestMatchers(HttpMethod.GET, "/authenticated").permitAll()
                        .requestMatchers(HttpMethod.POST, "/authenticate").permitAll()

                        // Alleen admin toegang voor het toevoegen van films
                        .requestMatchers(HttpMethod.POST, "/movie").hasRole("ADMIN")

                        // User en admin toegang voor de lijst van films en zoekfunctionaliteit
                        .requestMatchers(HttpMethod.GET, "/movies").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET, "/movie").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET, "/movie/{movieId}").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

                        // User en admin toegang voor het beoordelen van films en gemiddelde beoordelingen
                        .requestMatchers(HttpMethod.POST, "/{username}/rate-movie/{movieId}").permitAll() //Bug, weet niet waarom.. pff tijdelijke optie
                        .requestMatchers(HttpMethod.GET, "/{username}/has-rated/{movieId}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/movie/{movieId}/average-rating").permitAll() //Bug in de rating..

                        // Toegang voor user en admin tot beoordeelde films
                        .requestMatchers(HttpMethod.GET, "/{username}/rated-movies").permitAll() //Bug in de rating..
                        // Alleen admin toegang tot gebruikersbeheer
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/{username}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/images/upload").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/images/download").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/images/download/{username}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/{username}").hasRole("ADMIN")

                        // User en admin toegang tot autoriteiten en favorieten
                        .requestMatchers(HttpMethod.GET, "/users/{username}/authorities").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/{username}/authorities/ROLE_USER").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/{username}/favorite-movies").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/users/{username}/favorite-movies").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/{username}/favorite-movies").hasAnyRole("USER", "ADMIN")

                        // Toegang tot gezien-films voor user en admin
                        .requestMatchers(HttpMethod.POST, "/users/{username}/seen-movies").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/{username}/seen-movies").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/{username}/seen-movies").hasAnyRole("USER", "ADMIN")
                        .anyRequest().denyAll()

                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}