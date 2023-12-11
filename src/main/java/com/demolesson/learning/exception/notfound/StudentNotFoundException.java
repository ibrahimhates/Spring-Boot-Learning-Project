package com.demolesson.learning.exception.notfound;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends NotFoundException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
