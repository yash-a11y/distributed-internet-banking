package com.yash.core_banking_service.DTO;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class fundTransferReq {

    private String fromAcc;
    private String toAcc;
    private BigDecimal  amount;

}
