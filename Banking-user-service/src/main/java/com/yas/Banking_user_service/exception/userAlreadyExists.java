package com.yas.Banking_user_service.exception;

public class userAlreadyExists extends  bankingGlobException{
    public userAlreadyExists(String msg, String code)
    {
        super(msg, code);
    }
}
