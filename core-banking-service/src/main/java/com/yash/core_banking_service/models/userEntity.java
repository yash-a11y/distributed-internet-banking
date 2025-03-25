package com.yash.core_banking_service.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "banking_core_user")
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String identificationNum;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<bankAccountEntity> account;

}
