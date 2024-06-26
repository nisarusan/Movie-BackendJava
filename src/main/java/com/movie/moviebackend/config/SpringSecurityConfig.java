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

/*  Deze security is niet de enige manier om het te doen.
    In de andere branch van deze github repo staat een ander voorbeeld
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    public final CustomUserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    // PasswordEncoderBean. Deze kun je overal in je applicatie injecteren waar nodig.
    // Je kunt dit ook in een aparte configuratie klasse zetten.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // Authenticatie met customUserDetailsService en passwordEncoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(customUserDetailsService);
        return new ProviderManager(auth);
    }


    // Authorizatie met jwt
    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                                auth
                                        // Wanneer je deze uncomments, staat je hele security open. Je hebt dan alleen nog een jwt nodig.
                                        .requestMatchers("/**").permitAll()
//                                        .requestMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
//                                        // AuthenticationController
//                                        // UserController
//                                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.GET, "/users/**/authorities").hasAnyRole("ADMIN", "USER")
//                                        .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.POST, "/users/**/authorities").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.DELETE, "/users/**/authorities/**").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.POST, "/users/**/favorite-movies").hasAnyRole("ADMIN", "USER")
//                                        .requestMatchers(HttpMethod.GET, "/users/**/favorite-movies").hasAnyRole("ADMIN", "USER")
//                                        .requestMatchers(HttpMethod.DELETE, "/users/**/favorite-movies").hasAnyRole("ADMIN", "USER")
//                                        .requestMatchers(HttpMethod.POST, "/users/**/seen-movies").hasAnyRole("ADMIN", "USER")
//                                        .requestMatchers(HttpMethod.GET, "/users/**/seen-movies").hasAnyRole("ADMIN", "USER")
//                                        .requestMatchers(HttpMethod.DELETE, "/users/**/seen-movies").hasAnyRole("ADMIN", "USER")
//                                        // MovieController
//                                        .requestMatchers(HttpMethod.POST, "/movie").hasRole("ADMIN")
//                                        .requestMatchers(HttpMethod.GET, "/movies").hasAnyRole("USER", "ADMIN")
//                                        .requestMatchers(HttpMethod.GET, "/movie").hasAnyRole("USER", "ADMIN")
                                        // GenreController
////                                        .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
////                                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
//                                        // Je mag meerdere paths tegelijk definieren
//                                        .requestMatchers("/authenticated", "/authenticate", "/movies", "/").hasAnyRole("ADMIN", "USER")
                                        .requestMatchers("/authenticated").authenticated()
                                        .requestMatchers("/authenticate").permitAll()
                                        .anyRequest().denyAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}