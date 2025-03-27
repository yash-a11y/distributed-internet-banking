package com.yash.core_banking_service.DTO;

import com.yash.core_banking_service.models.bankAccountEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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

}
