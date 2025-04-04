package com.yash.core_banking_service.DTO;

import com.yash.core_banking_service.models.accountType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class bankAccount {

    private Long id;
    private String number;
    private accountType actype;
    private BigDecimal availBalance;
    private BigDecimal actualBalance;
    private User user;


}
