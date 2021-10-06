package com.example.userapp.web.rest.errors;

public class ParentUserNotFoundException extends Exception{
    public ParentUserNotFoundException() {
        super();
    }

    public ParentUserNotFoundException(String message) {
        super(message);
    }

    public ParentUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
