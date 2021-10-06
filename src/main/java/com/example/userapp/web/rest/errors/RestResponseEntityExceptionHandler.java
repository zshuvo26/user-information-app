package com.example.userapp.web.rest.errors;

import com.example.userapp.web.rest.errors.errorentity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException userNotFoundException, WebRequest webRequest){
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,userNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }
    @ExceptionHandler(ParentUserNotFoundException.class)
    public ResponseEntity<ErrorMessage> parentUserNotFoundException(ParentUserNotFoundException parentUserNotFoundException, WebRequest webRequest){
        ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,parentUserNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }
    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErrorMessage> invalidValueException(InvalidValueException invalidValueException, WebRequest webRequest){
        ErrorMessage message=new ErrorMessage(HttpStatus.BAD_REQUEST,invalidValueException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(message);
    }
    @ExceptionHandler(InvalidDeleteException.class)
    public ResponseEntity<ErrorMessage> InvalidDeleteException(InvalidDeleteException InvalidDeleteException, WebRequest webRequest){
        ErrorMessage message=new ErrorMessage(HttpStatus.BAD_REQUEST,InvalidDeleteException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(message);
    }
}
