package com.yash.core_banking_service.models;

import jakarta.persistence.*;

@Entity
@Table(name = "banking_core_utility_account")
public class utilityAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String provideName;

}
