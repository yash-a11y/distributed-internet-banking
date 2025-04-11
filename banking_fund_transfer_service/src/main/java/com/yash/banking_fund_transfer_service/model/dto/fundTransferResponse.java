package com.yash.banking_fund_transfer_service.model.dto;

import lombok.Data;

@Data
public class fundTransferResponse {
    private String message;
    private String transactionId;
}
