package com.movie.moviebackend.repository;

import com.movie.moviebackend.models.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageInfoRepository extends JpaRepository<ImageInfo, Long> {
    Optional<ImageInfo> findByUserUsername(String username);
}