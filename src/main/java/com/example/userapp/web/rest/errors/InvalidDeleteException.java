package com.example.userapp.web.rest.errors;

public class InvalidDeleteException extends Exception {
    public InvalidDeleteException() {
        super();
    }

    public InvalidDeleteException(String message) {
        super(message);
    }

    public InvalidDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

}
