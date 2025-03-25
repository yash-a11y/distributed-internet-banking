package com.yash.core_banking_service.repository;

import com.yash.core_banking_service.models.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<userEntity, Long>
{
}
