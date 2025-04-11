package com.yash.utility_payment_service.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class utilityPaymentReq {
    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;

}
