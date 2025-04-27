package com.yash.banking_fund_transfer_service.service;

import com.yash.banking_fund_transfer_service.config.customFeignClientConfig;
import com.yash.banking_fund_transfer_service.model.dto.fundTransferRequest;
import com.yash.banking_fund_transfer_service.model.dto.fundTransferResponse;
import com.yash.banking_fund_transfer_service.model.dto.response.accountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "core-banking-service", configuration = customFeignClientConfig.class)
public interface bankingCoreFeignClient {

    @RequestMapping(path = "/api/v1/account/bank-account/{account_number}", method = RequestMethod.GET)
    accountResponse readAccount(@PathVariable("account_number")String accountNumber);

    @RequestMapping(path = "/api/v1/transaction/fund-transfer", method = RequestMethod.POST)
    fundTransferResponse fundTransfer(@RequestBody fundTransferRequest fundTransferRequest);




}
