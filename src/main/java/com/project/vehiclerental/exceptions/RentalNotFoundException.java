package com.project.vehiclerental.exceptions;

public class RentalNotFoundException extends RuntimeException {

    public RentalNotFoundException(Long id) {
        super("Rental not found with id: " + id);
    }
}
