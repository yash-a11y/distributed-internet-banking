package com.yash.core_banking_service.exception;

public class entityNotFoundException extends bankingGlobException{

    public entityNotFoundException(){
        super("Requested entity not present in the DB...",gloabErrorCode.ENTITY_NOT_FOUND);

    }

    public entityNotFoundException(String message)
    {
        super(message, gloabErrorCode.ENTITY_NOT_FOUND);
    }
}
