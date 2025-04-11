package com.yash.banking_fund_transfer_service.controller;

import com.yash.banking_fund_transfer_service.model.dto.fundTransferRequest;
import com.yash.banking_fund_transfer_service.service.fundTransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transfer")
public class fundTransferController {
    @Autowired
    private final fundTransferService fundTransferService;

    @PostMapping
    public ResponseEntity sendFund(@RequestBody fundTransferRequest fundTransferReq)
    {
        log.info("transfer request...{}", fundTransferReq.toString());

        return ResponseEntity.ok(
                fundTransferService.fundTransfer(
                        fundTransferReq
                )
        );
    }

    @GetMapping
    public ResponseEntity readTransfers(Pageable pageable){
        log.info("reading fund transfers");
        return ResponseEntity.ok(
                fundTransferService.readAllTransfers(
                        pageable
                )
        );
    }
}
