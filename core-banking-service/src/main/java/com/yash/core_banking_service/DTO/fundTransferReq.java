package com.yash.core_banking_service.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class fundTransferReq {

    private String fromAccount;
    private String toAccount;
    private BigDecimal  amount;


}
