package com.project.vehiclerental.advice.exception;

public class FileUploadException extends SpringBootFileUploadException {
    public FileUploadException(String message) {
        super(message);
    }
}
