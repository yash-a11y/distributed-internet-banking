package com.yash.core_banking_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
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

    private BigDecimal availableBalance;

    private  BigDecimal actualBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private userEntity user;



}
