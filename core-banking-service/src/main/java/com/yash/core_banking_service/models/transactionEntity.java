package com.yash.core_banking_service.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@Entity
@Table(name = "banking_core_transaction")
@AllArgsConstructor
@NoArgsConstructor
public class transactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
