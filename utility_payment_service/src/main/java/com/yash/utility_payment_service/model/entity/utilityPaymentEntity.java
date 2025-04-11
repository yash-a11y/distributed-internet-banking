package com.yash.utility_payment_service.model.entity;

import com.yash.utility_payment_service.model.transactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.TransactionStatus;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "utility_payment")
public class utilityPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long providedId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
    private String transactionId;

    @Enumerated(EnumType.STRING)
    private transactionStatus status;


}
