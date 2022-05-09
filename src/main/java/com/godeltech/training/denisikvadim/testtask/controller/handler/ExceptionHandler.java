package com.godeltech.training.denisikvadim.testtask.controller.handler;

import com.godeltech.training.denisikvadim.testtask.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    protected ResponseEntity handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
