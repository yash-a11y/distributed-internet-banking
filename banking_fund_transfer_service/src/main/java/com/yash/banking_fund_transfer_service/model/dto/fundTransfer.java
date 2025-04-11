package com.yash.banking_fund_transfer_service.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class fundTransfer {
    private Long id;
    private String transactionReference;
    private String status;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
