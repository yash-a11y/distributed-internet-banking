package com.yas.Banking_user_service.exception;

public class invalidEmailException extends  bankingGlobException{
    public invalidEmailException(String message, String code)
    {
        super(message, code);
    }
}
