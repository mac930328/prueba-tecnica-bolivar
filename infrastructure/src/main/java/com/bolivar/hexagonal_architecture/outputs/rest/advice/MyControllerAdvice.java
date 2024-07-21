package com.bolivar.hexagonal_architecture.outputs.rest.advice;

import com.bolivar.hexagonal_architecture.domain.execptions.NotFoundRegisterException;
import com.bolivar.hexagonal_architecture.outputs.rest.exceptions.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(NotFoundRegisterException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<GlobalError> notFoundObjectExceptionHandler(NotFoundRegisterException notFoundObjectException) {
        GlobalError globalError = GlobalError.builder().status(HttpStatus.NOT_FOUND.value())
                .message(notFoundObjectException.getMessage()).build();
        return new ResponseEntity<GlobalError>(globalError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GlobalError> notFoundObjectExceptionHandler(IllegalArgumentException notFoundObjectException) {
        GlobalError globalError = GlobalError.builder().status(HttpStatus.BAD_REQUEST.value())
                .message(notFoundObjectException.getMessage()).build();
        return new ResponseEntity<GlobalError>(globalError, HttpStatus.NOT_FOUND);
    }

}
