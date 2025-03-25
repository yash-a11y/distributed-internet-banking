package com.yash.core_banking_service.models;

import jakarta.persistence.*;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Entity
@Table(name = "banking_core_transaction")
public class transactionEntity {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private transactionType transactionType;

    private String referenceNumber;

    private String transactionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private bankAccountEntity account;


}
