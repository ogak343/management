package com.example.managingcabinet.infastructure.exception;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UnhandledException {

    @ExceptionHandler(Exception.class)
    public ApplicationException unhandledException(@NotNull Exception e) {
        throw ApplicationException.unhandled(e);
    }
}
