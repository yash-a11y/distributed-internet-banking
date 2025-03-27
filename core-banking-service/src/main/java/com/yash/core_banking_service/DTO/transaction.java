package com.yash.core_banking_service.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class transaction {
    private Long id;
    private BigDecimal amount;
    private bankAccount bankaccount;
    private String refNumber;
}
