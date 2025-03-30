package com.yash.core_banking_service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "banking_core_user")
@Getter
@Setter
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<bankAccountEntity> account;

    public void setBankAccounts(List<bankAccountEntity> account) {
        this.account = account;
    }

    public List<bankAccountEntity> getBankAccounts() {
        return account;
    }
}
