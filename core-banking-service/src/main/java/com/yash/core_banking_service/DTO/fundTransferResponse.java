package com.yash.core_banking_service.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class fundTransferResponse {

    private String msg;
    private String transactionId;

}
