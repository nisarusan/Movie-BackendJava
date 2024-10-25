package com.movie.moviebackend.service;

import com.movie.moviebackend.models.ImageInfo;
import com.movie.moviebackend.models.User;
import com.movie.moviebackend.repositories.UserRepository;
import com.movie.moviebackend.repository.ImageInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    private ImageInfoRepository imageInfoRepository;

    @Autowired
    private UserRepository userRepository;

    public ImageInfo storeImage(MultipartFile file, String username) throws IOException {
        User user = userRepository.findById(username).orElseThrow(() -> new RuntimeException("User not found"));

        ImageInfo imageInfo = imageInfoRepository.findByUserUsername(username).orElse(null);
        if (imageInfo == null) {
            imageInfo = new ImageInfo();
        }

        imageInfo.setFileName(file.getOriginalFilename());
        imageInfo.setFileType(file.getContentType());
        imageInfo.setData(file.getBytes());
        imageInfo.setUser(user);

        return imageInfoRepository.save(imageInfo);
    }

    public ImageInfo getImage(String username) {
        return imageInfoRepository.findByUserUsername(username).orElseThrow(() -> new RuntimeException("Image not found"));
    }
    @Transactional
    public void deleteImage(String username) {
        ImageInfo imageInfo = imageInfoRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        imageInfoRepository.delete(imageInfo);
        imageInfoRepository.flush(); // Ensure the deletion is committed
        System.out.println("Deleted image for user: " + username);
    }
}