package com.demolesson.learning.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    private HttpStatus status;

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
