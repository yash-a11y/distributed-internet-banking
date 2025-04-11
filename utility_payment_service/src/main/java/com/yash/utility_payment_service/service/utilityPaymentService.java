package com.yash.utility_payment_service.service;

import com.yash.utility_payment_service.model.dto.request.utilityPaymentReq;
import com.yash.utility_payment_service.model.dto.response.utilityPaymentRes;
import com.yash.utility_payment_service.model.dto.utilityPayment;
import com.yash.utility_payment_service.model.entity.utilityPaymentEntity;
import com.yash.utility_payment_service.model.mapper.utilityPaymentMapper;
import com.yash.utility_payment_service.model.repo.utilityPaymentRepo;
import com.yash.utility_payment_service.model.transactionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class utilityPaymentService {


    @Autowired
    private utilityPaymentRepo utilityPaymentRepository;

    private utilityPaymentMapper utilityPaymentMapper = new utilityPaymentMapper();

    public utilityPaymentRes payment(utilityPaymentReq utilityPaymentRequest)
    {
        log.info("utility payment process... {} ", utilityPaymentRequest.toString());

        utilityPaymentEntity entity = new utilityPaymentEntity();

        BeanUtils.copyProperties(utilityPaymentRequest, entity);

        entity.setStatus(transactionStatus.PROCESSING);

        utilityPaymentEntity optPayment = utilityPaymentRepository.save(entity);

        String trasactionId = UUID.randomUUID().toString();

        optPayment.setStatus(transactionStatus.SUCCESS);

        optPayment.setTransactionId(trasactionId);

        utilityPaymentRepository.save(optPayment);
        return utilityPaymentRes.builder().message("util payment successfully processed")
                .transactionId(trasactionId).build();
    }

    public List<utilityPayment> readPayments(Pageable pageable)
    {
        Page<utilityPaymentEntity> allutilPayment = utilityPaymentRepository.findAll(pageable);
        return utilityPaymentMapper.convertToDtoList(allutilPayment.getContent());

    }
}
