
package com.movie.moviebackend.repositories;

import com.movie.moviebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


//    Optional<User> findByUsername(String username);

    //old
    User findByUsername(String username);

}
