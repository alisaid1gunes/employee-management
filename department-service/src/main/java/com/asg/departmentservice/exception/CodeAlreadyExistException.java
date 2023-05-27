package com.asg.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CodeAlreadyExistException extends RuntimeException{
    private String message;

    public CodeAlreadyExistException(String message) {
        super(message);
    }
}