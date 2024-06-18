package com.remedio.thiago.curso.ErrorFilter;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorFilter {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> ErrorFilter404(){
        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ErrorFilter400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
    }

    public record DadosErros(String campo, String messagem){
        public DadosErros(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }
}
