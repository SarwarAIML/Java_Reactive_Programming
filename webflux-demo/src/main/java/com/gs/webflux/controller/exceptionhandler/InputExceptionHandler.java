package com.gs.webflux.controller.exceptionhandler;

import com.gs.webflux.dto.InputFailedValidationResponse;
import com.gs.webflux.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.util.retry.Retry;

@ControllerAdvice

public class InputExceptionHandler {
    @ExceptionHandler(InputValidationException.class)

    public ResponseEntity<InputFailedValidationResponse> handleException(InputValidationException exception){
        InputFailedValidationResponse response = new InputFailedValidationResponse();
        response.setErrorCode(exception.getErrorCode());
        response.setInput(exception.getInput());
        response.setErrorMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(response);

    }


}