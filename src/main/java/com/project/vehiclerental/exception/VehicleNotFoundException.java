package com.project.vehiclerental.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(Long id) {
        super("vehicle not found with id: " + id);
    }
}
