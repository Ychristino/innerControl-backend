package com.innerControl.innerControl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        // Retornar uma resposta personalizada
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomError("Erro", ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Retornar uma resposta personalizada
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomError("Erro", ex.getMessage()));
    }
    // Classe para representar o erro personalizado
    public static class CustomError {
        private String error;
        private String message;

        public CustomError(String error, String message) {
            this.error = error;
            this.message = message;
        }

        // Getters e setters
        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

