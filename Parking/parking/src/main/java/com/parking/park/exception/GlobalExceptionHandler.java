package com.parking.park.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class GlobalExceptionHandler {
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }
}
