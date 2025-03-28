package com.yash.core_banking_service.repository;

import com.yash.core_banking_service.DTO.User;
import com.yash.core_banking_service.models.userEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.net.ContentHandler;
import java.util.Optional;

public interface userRepo extends JpaRepository<userEntity, Long>
{
    Optional<userEntity> findByIdentificationNumber(String identify);

     Page<userEntity> findAll(Pageable pageable);
}
