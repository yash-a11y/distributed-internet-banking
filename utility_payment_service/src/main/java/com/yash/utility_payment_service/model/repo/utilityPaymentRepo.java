package com.yash.utility_payment_service.model.repo;

import com.yash.utility_payment_service.model.dto.utilityPayment;
import com.yash.utility_payment_service.model.entity.utilityPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface utilityPaymentRepo extends JpaRepository<utilityPaymentEntity, utilityPayment> {
}
