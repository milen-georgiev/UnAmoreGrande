package com.example.unamoregrande.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Object not found!")
public class NumberFormatException extends RuntimeException {
    public NumberFormatException(String message) {
        super(message);
    }
}
