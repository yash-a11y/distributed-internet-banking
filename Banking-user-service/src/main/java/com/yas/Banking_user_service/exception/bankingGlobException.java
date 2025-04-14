
package com.yas.Banking_user_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class bankingGlobException extends RuntimeException{
    private String code;
    private  String message;

    public bankingGlobException(String message)
    {
        super(message);
    }
}
