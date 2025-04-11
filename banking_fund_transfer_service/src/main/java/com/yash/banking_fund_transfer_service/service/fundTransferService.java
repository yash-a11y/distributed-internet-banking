package com.yash.banking_fund_transfer_service.service;

import com.yash.banking_fund_transfer_service.model.dto.fundTransfer;
import com.yash.banking_fund_transfer_service.model.dto.fundTransferRequest;
import com.yash.banking_fund_transfer_service.model.dto.fundTransferResponse;
import com.yash.banking_fund_transfer_service.model.entity.fundTransferEntity;
import com.yash.banking_fund_transfer_service.model.mapper.fundTransferMapper;
import com.yash.banking_fund_transfer_service.model.repo.fundTransferRepo;
import com.yash.banking_fund_transfer_service.model.transactionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class fundTransferService {

    @Autowired
    private fundTransferRepo fundTransferRepository;

    private fundTransferMapper mapper = new fundTransferMapper();


    public fundTransferResponse fundTransfer(fundTransferRequest req)
    {
        log.info("sending fund transfer request {}" + req.toString());

        fundTransferEntity entity = new fundTransferEntity();
        BeanUtils.copyProperties(
                req, entity
        );
        entity.setStatus(transactionStatus.PENDING);
        fundTransferEntity optFundTransfer = fundTransferRepository.save(entity);

        fundTransferResponse response = new fundTransferResponse();
        response.setTransactionId(
                UUID.randomUUID().toString()
        );
        response.setMessage("Success");

        return response;
    }

    public List<fundTransfer> readAllTransfers(Pageable pageable)
    {
      return  mapper.convertToDtoList(fundTransferRepository.findAll(pageable).getContent());
    }
}
