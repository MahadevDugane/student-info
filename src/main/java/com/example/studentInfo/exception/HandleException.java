package com.example.studentInfo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex){
        System.out.println("handling exception");
        System.out.println(ex.getMessage());
    }
}
