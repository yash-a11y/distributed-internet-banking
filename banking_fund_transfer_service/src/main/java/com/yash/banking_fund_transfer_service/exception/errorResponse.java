package com.yash.banking_fund_transfer_service.exception;

import lombok.Builder;



@Builder
public class errorResponse {
    private String code;
    private String message;
}
