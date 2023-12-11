package com.demolesson.learning.exception.badrequest;

import com.demolesson.learning.exception.BaseException;
import org.springframework.http.HttpStatus;

public abstract class BadRequestException extends BaseException {
    public BadRequestException(String message) {
        super(message,  HttpStatus.BAD_REQUEST);
    }
}
