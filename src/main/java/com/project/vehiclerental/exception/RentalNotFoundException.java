package com.project.vehiclerental.exception;

public class RentalNotFoundException extends RuntimeException {

    public RentalNotFoundException(Long id) {
        super("rental not found with id: " + id);
    }
}
