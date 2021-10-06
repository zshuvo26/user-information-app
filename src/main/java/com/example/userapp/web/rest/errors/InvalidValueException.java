package com.example.userapp.web.rest.errors;

public class InvalidValueException extends Exception {
    public InvalidValueException() {
        super();
    }

    public InvalidValueException(String message) {
        super(message);
    }

    public InvalidValueException(String message, Throwable cause) {
        super(message, cause);
    }

}
