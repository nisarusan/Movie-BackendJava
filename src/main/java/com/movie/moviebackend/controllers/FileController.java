package com.movie.moviebackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload/{username}")
    public ResponseEntity<String> uploadFile(@PathVariable String username, @RequestParam("file") MultipartFile file) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR + username + "-" + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{username}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String username) {
        try {
            // Assuming you save files with username-prefix, find the file
            Path filePath = Files.list(Paths.get(UPLOAD_DIR))
                    .filter(path -> path.getFileName().toString().startsWith(username))
                    .findFirst()
                    .orElse(null);

            if (filePath == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            byte[] fileBytes = Files.readAllBytes(filePath);
            return new ResponseEntity<>(fileBytes, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> deleteFile(@PathVariable String username) {
        try {
            // Assuming you save files with username-prefix, find the file
            Path filePath = Files.list(Paths.get(UPLOAD_DIR))
                    .filter(path -> path.getFileName().toString().startsWith(username))
                    .findFirst()
                    .orElse(null);

            if (filePath == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Files.delete(filePath);
            return new ResponseEntity<>("File deleted successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("File deletion failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}