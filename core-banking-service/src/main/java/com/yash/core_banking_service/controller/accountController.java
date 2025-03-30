package com.yash.core_banking_service.controller;

import com.yash.core_banking_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/account")
@RequiredArgsConstructor
public class accountController {

    private final AccountService accountService;

    @GetMapping("/util-account/{account_name}")
    public ResponseEntity getUtilityAcc(@PathVariable("account_name") String providerName){

        log.info("reading utility account by Id {}", providerName);
        return  ResponseEntity.ok(
                accountService.readutilityAccount(providerName)
        );
    }

}
