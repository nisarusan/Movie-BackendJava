
package com.movie.moviebackend.repositories;


import com.movie.moviebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
