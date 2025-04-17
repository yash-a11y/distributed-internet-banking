package com.yas.Banking_user_service.config;

import com.yas.Banking_user_service.exception.bankingGlobException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class customFeignErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {

        bankingGlobException bankingGlobException = ex
    }
}
