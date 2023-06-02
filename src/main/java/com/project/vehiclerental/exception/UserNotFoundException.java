package com.project.vehiclerental.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("user not found with id: " + id);
    }
}
