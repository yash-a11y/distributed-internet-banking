package com.yash.utility_payment_service.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class utilityPaymentRes {
    private String message;
    private String transactionId;
}
