package com.yash.core_banking_service.DTO;

import com.yash.core_banking_service.models.accountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class bankAccount {

    private Long id;
    private String number;
    private accountType actype;
    private BigDecimal availBalance;
    private BigDecimal actualBalance;
    private User user;


}
