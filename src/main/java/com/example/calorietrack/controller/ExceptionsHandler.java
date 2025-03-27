package com.example.calorietrack.controller;

import com.example.calorietrack.dto.ErrorResponse;
import com.example.calorietrack.exception.CalorieTrackException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;


/**
 * Контроллер обработки ошибок.
 */
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(CalorieTrackException.class)
    public ResponseEntity<ErrorResponse> handleException(CalorieTrackException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        ErrorResponse errors = new ErrorResponse();
        e.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    errors.setError(Objects.requireNonNull(error.getDefaultMessage()));
                }
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ConstraintViolationException e){
        ErrorResponse errors = new ErrorResponse();
        e.getConstraintViolations().forEach(
                (constraintViolation -> errors.setError(constraintViolation.getMessage()))
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
