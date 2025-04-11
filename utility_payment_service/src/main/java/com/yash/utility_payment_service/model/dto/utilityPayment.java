package com.yash.utility_payment_service.model.dto;

import lombok.Data;
import org.springframework.transaction.TransactionStatus;

import java.math.BigDecimal;

@Data
public class utilityPayment {
    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
    private TransactionStatus status;

}
