package com.api.crud.exercises.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BookException.class)
    public String optionNotFound(BookException bookException){
        return String.format("Number or character invalid", bookException.getId());
    }

}
