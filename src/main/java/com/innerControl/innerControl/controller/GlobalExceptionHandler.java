package com.innerControl.innerControl.controller;

import jakarta.validation.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<List<CustomError>> handleRuntimeException(RuntimeException ex) {
        // Criar uma lista de CustomError com a mensagem da exceção
        List<CustomError> customErrors = new ArrayList<>();
        customErrors.add(new CustomError("Erro", ex.getMessage()));

        // Retornar a lista de erros com status BAD_REQUEST
        return new ResponseEntity<>(customErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<List<CustomError>> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Criar uma lista de CustomError com a mensagem da exceção
        List<CustomError> customErrors = new ArrayList<>();
        customErrors.add(new CustomError("Erro", ex.getMessage()));

        // Retornar a lista de erros com status BAD_REQUEST
        return new ResponseEntity<>(customErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<CustomError>> handleValidationException(MethodArgumentNotValidException ex) {
        // Extrair erros de validação
        List<String> erros = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        // Criar uma lista de CustomError, cada erro com sua mensagem
        List<CustomError> customErrors = erros.stream()
                .map(msg -> new CustomError("Erro", msg))
                .collect(Collectors.toList());

        // Retornar lista de erros
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrors);
    }

    @ExceptionHandler(Exception.class)  // Exceção genérica para capturar exceções não tratadas
    public ResponseEntity<List<CustomError>> handleGenericException(Exception ex) {
        // Criar uma lista de CustomError com erro genérico
        List<CustomError> customErrors = new ArrayList<>();
        customErrors.add(new CustomError("Erro", "Ocorreu um erro inesperado."));

        // Retornar lista de erros com status INTERNAL_SERVER_ERROR
        return new ResponseEntity<>(customErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Método auxiliar para criar a resposta personalizada
    private ResponseEntity<List<CustomError>> buildErrorResponse(HttpStatus status, String message) {
        List<CustomError> customErrors = new ArrayList<>();
        customErrors.add(new CustomError("Erro", message));

        return new ResponseEntity<>(customErrors, status);
    }

    // Classe para representar o erro personalizado
    public static class CustomError {
        private String error;
        private String message;
        private String timestamp = LocalDateTime.now().toString();

        // Construtor
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

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
