package com.movie.moviebackend.controller;

import com.movie.moviebackend.models.ImageInfo;
import com.movie.moviebackend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<ImageInfo> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("username") String username) throws IOException {
        ImageInfo imageInfo = imageService.storeImage(file, username);
        return new ResponseEntity<>(imageInfo, HttpStatus.OK);
    }

    @GetMapping("/download/{username}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String username) {
        ImageInfo imageInfo = imageService.getImage(username);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageInfo.getFileName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, imageInfo.getFileType())
                .body(imageInfo.getData());
    }


    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Void> deleteImage(@PathVariable String username) {
        imageService.deleteImage(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}