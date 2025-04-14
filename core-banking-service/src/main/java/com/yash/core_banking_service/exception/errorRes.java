package com.yash.core_banking_service.exception;

import lombok.Builder;

@Builder
public class errorRes {
    private String code;
    private String message;

}
