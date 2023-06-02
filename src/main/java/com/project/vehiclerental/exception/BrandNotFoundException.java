package com.project.vehiclerental.exception;

public class BrandNotFoundException extends RuntimeException {

    public BrandNotFoundException(Long id) {
        super("brand not found with id: " + id);
    }
}
