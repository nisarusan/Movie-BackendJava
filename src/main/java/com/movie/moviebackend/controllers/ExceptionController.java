
package com.movie.moviebackend.controllers;


import com.movie.moviebackend.exceptions.BadRequestException;
import com.movie.moviebackend.exceptions.RecordNotFoundException;
import com.movie.moviebackend.exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    //    Deze exception handler vangt elke RecordNotFoundException op die naar de gebruiker gegooid wordt en returned daar voor in de plaats een ResponseEntity met de Message en de NOT_FOUND-status (404)
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

    }

    //    Deze exception handler vangt elke IndexOutOfBoundsException (deze exception komt uit de java.utils package) op die naar de gebruiker gegooid wordt en returned daar voor in de plaats een ResponseEntity met de Message en de NOT_FOUND-status (404)

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> exception(IndexOutOfBoundsException exception) {

        return new ResponseEntity<>("Dit id staat niet in de database", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> exception(BadRequestException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<String> exception(UsernameNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }



}