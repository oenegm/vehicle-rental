package com.project.vehiclerental.advice.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(Long id) {
        super("vehicle not found with id: " + id);
    }
}
