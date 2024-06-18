package com.remedio.thiago.curso.ErrorFilter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorFilter {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> ErrorFilter404(){
        return ResponseEntity.notFound().build();

    }
}
