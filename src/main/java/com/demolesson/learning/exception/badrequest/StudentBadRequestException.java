package com.demolesson.learning.exception.badrequest;

import org.springframework.http.HttpStatus;

public class StudentBadRequestException extends BadRequestException{
    public StudentBadRequestException(String message) {
        super(message);
    }
}
