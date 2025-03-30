package com.yash.core_banking_service.repository;

import com.yash.core_banking_service.models.utilityAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface utilityAccountRepo extends JpaRepository<utilityAccountEntity, Long> {

    Optional<utilityAccountEntity> findByProviderName(String providerName);

}
