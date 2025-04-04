package com.yash.core_banking_service.repository;

import com.yash.core_banking_service.models.bankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface bankAccountRepo extends JpaRepository<bankAccountEntity, Long> {

    Optional<bankAccountEntity> findByNumber(String number);
}
