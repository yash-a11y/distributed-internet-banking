package com.yash.core_banking_service.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class fundTransferReq {

    private String fromAcc;
    private String toAcc;
    private BigDecimal  amount;

    public String getFromAcc() {
        return fromAcc;
    }

    public String getToAcc() {
        return toAcc;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
