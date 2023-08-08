package com.project.vehiclerental.advice;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class ErrorDto implements Serializable {
    String code;
    String message;
}
