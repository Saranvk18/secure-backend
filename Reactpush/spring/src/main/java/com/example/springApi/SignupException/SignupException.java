package com.example.springApi.SignupException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SignupException extends RuntimeException {

    public SignupException(String message) {
        super(message);
    }
}
