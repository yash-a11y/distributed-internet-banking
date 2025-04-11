package com.yash.utility_payment_service.controller;

import com.netflix.discovery.converters.Auto;
import com.yash.utility_payment_service.model.dto.request.utilityPaymentReq;
import com.yash.utility_payment_service.service.utilityPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/utility-payment")
public class utilityPaymentController {

    @Autowired
    private utilityPaymentService utilityPaymentService;

    @GetMapping
    public ResponseEntity readPayments(Pageable pageable)
    {
        return ResponseEntity.ok(
                utilityPaymentService.readPayments(pageable)
        );
    }


    @PostMapping
    public ResponseEntity processPayment(@RequestBody utilityPaymentReq request)
    {
        return ResponseEntity.ok(
                utilityPaymentService.payment(request)
        );

    }
}
