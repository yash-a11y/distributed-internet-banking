
package com.yas.Banking_user_service.exception;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

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


    private bankingGlobException extractBankingGlobException(Response response)
    {
        bankingGlobException exceptionMsg = null;
        Reader reader = null;

        try{
            reader = response.body().asReader(
                    StandardCharsets.UTF_8
            );
            String result = IOUtils.toString(reader);
            ObjectMapper mapper = new ObjectMapper();

            mapper.disable(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
            );



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
