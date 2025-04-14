package com.yas.Banking_user_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class globExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(bankingGlobException.class)
    protected ResponseEntity handleGlobException(bankingGlobException bankingGlobException, Locale locale){
        return ResponseEntity.badRequest()
                .body(errorRes.builder()
                        .code(bankingGlobException.getCode())
                        .message(bankingGlobException.getMessage())
                        .build()
                );
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e, Locale locale){
        return ResponseEntity.badRequest()

                .body("Exception occur inside API "+ e);
    }

}
