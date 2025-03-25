package com.yash.core_banking_service.repository;

import com.yash.core_banking_service.models.transactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionRepo extends JpaRepository<transactionEntity, Long> {
}
