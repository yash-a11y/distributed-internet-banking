package com.yash.banking_fund_transfer_service.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class fundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private String authID;
}
