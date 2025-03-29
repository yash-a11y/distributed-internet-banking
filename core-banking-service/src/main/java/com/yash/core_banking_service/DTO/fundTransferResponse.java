package com.yash.core_banking_service.DTO;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class fundTransferResponse {

    private String msg;
    private String transactionId;

}
