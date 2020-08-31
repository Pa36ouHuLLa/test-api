package com.example.demo.filters;

import com.example.demo.entities.RestExceptionDto;
import com.example.demo.exceptions.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { TaskNotFoundException.class})
    protected ResponseEntity<RestExceptionDto> handleConflict(RuntimeException ex) {
        return ResponseEntity.badRequest().body(new RestExceptionDto(ex));
    }
}

