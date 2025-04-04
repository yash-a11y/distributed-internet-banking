package com.yas.Banking_user_service.model.repo;

import com.yas.Banking_user_service.model.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<userEntity, Long> {
}
