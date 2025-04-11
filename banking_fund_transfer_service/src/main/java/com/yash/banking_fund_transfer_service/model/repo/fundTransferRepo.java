package com.yash.banking_fund_transfer_service.model.repo;

import com.yash.banking_fund_transfer_service.model.entity.fundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface fundTransferRepo extends JpaRepository<fundTransferEntity, Long>
{
}
