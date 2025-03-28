package com.yash.core_banking_service.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class utilityPaymentReq {


    private Long providerId;
    private BigDecimal amount;
    private String referenceNum;
    private String account;



}
