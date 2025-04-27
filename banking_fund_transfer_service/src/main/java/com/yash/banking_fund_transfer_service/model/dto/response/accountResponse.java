package com.yash.banking_fund_transfer_service.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class accountResponse {
    private Long number;
    private BigDecimal actualBalance;
    private Long id;
    private  String type;
    private String status;
    private BigDecimal availableBalance;
}
