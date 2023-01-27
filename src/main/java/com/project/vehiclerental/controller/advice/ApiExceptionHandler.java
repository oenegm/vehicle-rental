package com.project.vehiclerental.controller.advice;

import com.project.vehiclerental.exception.BrandNotFoundException;
import com.project.vehiclerental.exception.RentalNotFoundException;
import com.project.vehiclerental.exception.UserNotFoundException;
import com.project.vehiclerental.exception.VehicleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({BrandNotFoundException.class, RentalNotFoundException.class, UserNotFoundException.class, VehicleNotFoundException.class})
    ResponseEntity<?> advice(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
