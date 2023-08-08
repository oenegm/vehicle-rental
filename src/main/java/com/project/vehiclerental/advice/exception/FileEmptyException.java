package com.project.vehiclerental.exception;

public class FileEmptyException extends SpringBootFileUploadException {
    public FileEmptyException(String message) {
        super(message);
    }
}