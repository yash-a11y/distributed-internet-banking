package com.yas.Banking_user_service.exception;

public class entityNotFound extends  bankingGlobException{

    public entityNotFound(){
        super("requested entity not present in the DB. ",
                GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);

    }

    public entityNotFound(String msg)
    {
        super(msg, GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }
}
