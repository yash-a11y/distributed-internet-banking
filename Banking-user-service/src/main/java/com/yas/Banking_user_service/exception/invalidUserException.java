package com.yas.Banking_user_service.exception;

public class invalidUserException extends bankingGlobException{

    public invalidUserException(String message, String code)
    {
        super(message, code);
    }
}
