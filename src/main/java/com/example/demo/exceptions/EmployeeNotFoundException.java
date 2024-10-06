package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNotFoundException extends  RuntimeException{

    private String code;
    private String message;

    public EmployeeNotFoundException(String message){
        super(message);
        this.code = "EMP001";
        this.message = message;
    }

}
