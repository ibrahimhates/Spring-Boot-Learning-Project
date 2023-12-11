package com.demolesson.learning.exception.notfound;

import com.demolesson.learning.exception.BaseException;
import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
