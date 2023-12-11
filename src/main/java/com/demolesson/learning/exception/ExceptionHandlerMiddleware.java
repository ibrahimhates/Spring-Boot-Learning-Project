package com.demolesson.learning.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerMiddleware {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(BaseException exception) {

        ErrorResponse error = new ErrorResponse(
                exception.getMessage(),
                exception.getStatus().value(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, exception.getStatus());
    }
}
