package com.yash.core_banking_service.DTO;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String identificationNum;
    private List<bankAccount> account;

    public List<bankAccount> getBankAccounts() {
        return account;
    }

    public void setBankAccounts(List<bankAccount> account) {
        this.account = account;
    }
}
