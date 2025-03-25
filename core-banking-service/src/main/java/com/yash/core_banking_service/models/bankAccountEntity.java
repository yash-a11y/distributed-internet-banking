package com.yash.core_banking_service.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "banking_core_account")
public class bankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private accountType type;

    @Enumerated(EnumType.STRING)
    private accountStatus status;

    private BigDecimal availBalance;

    private  BigDecimal actBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private userEntity user;
}
