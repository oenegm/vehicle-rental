package com.project.vehiclerental.advice.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("user not found with id: " + id);
    }
}
