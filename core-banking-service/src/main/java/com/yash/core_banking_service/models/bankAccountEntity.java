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

    private BigDecimal availBalance;

    private  BigDecimal actBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private userEntity user;


    public void setActBalance(BigDecimal actBalance) {
        this.actBalance = actBalance;
    }

    public void setAvailBalance(BigDecimal availBalance) {
        this.availBalance = availBalance;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getActBalance() {
        return actBalance;
    }
}
