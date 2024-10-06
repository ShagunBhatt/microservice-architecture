package com.example.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleGlobalException(EmployeeNotFoundException employeeNotFoundException, Locale locale) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder().code(employeeNotFoundException.getCode())
                        .message(employeeNotFoundException.getMessage())
                        .build());
    }

}
