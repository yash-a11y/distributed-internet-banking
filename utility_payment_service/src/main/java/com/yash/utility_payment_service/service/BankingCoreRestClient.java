package com.yash.utility_payment_service.service;

import com.yash.utility_payment_service.config.customFeignClientConfig;
import com.yash.utility_payment_service.model.dto.request.utilityPaymentReq;
import com.yash.utility_payment_service.model.dto.response.accountResponse;
import com.yash.utility_payment_service.model.dto.response.utilityPaymentRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "core-banking-service", configuration = customFeignClientConfig.class)
public interface BankingCoreRestClient {

    @RequestMapping(path = "/api/v1/account/bank-account/{account_number}", method = RequestMethod.GET)
    accountResponse readAccount(@PathVariable("account_number") String accountNumber);

    @RequestMapping(path = "/api/v1/transaction/util-payment", method = RequestMethod.POST)
    utilityPaymentRes utilityPayment(@RequestBody utilityPaymentReq paymentReq);

}
