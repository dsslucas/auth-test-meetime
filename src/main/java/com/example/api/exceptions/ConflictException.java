package com.example.api.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException (String message) {
        super(message);
    }
}
