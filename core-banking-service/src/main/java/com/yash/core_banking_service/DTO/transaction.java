package com.yash.core_banking_service.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class transaction {
    private Long id;
    private BigDecimal amount;
    private bankAccount bankAccount;
    private String refNumber;
}
