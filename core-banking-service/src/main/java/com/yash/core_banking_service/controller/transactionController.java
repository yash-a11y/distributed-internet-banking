package com.yash.core_banking_service.controller;

import com.yash.core_banking_service.DTO.fundTransferReq;
import com.yash.core_banking_service.DTO.utilityPaymentReq;
import com.yash.core_banking_service.service.transactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transaction")
public class transactionController {

    private final transactionService  transactionService;

    @PostMapping("/fund-transfer")
    public ResponseEntity fundTransfer(@RequestBody
                                       fundTransferReq fundTransferRequest)
    {
        log.info("transfer initiated in core bandk from{}"
        ,fundTransferRequest.toString());

        return ResponseEntity.ok(
                transactionService.fundtransfer(fundTransferRequest)
        );

    }

    @PostMapping("/utill-payment")
    public ResponseEntity utilPayment(@RequestBody utilityPaymentReq utilityPaymentRequest)
    {
        log.info("Utility Payment initiated in core bank from {}", utilityPaymentRequest.toString());
        return ResponseEntity.ok(transactionService.utilityPaymentRes(utilityPaymentRequest));

    }
    }

