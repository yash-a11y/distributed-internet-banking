package com.yash.core_banking_service.service;

import com.yash.core_banking_service.DTO.*;
import com.yash.core_banking_service.models.bankAccountEntity;
import com.yash.core_banking_service.models.transactionEntity;
import com.yash.core_banking_service.models.transactionType;
import com.yash.core_banking_service.repository.bankAccountRepo;
import com.yash.core_banking_service.repository.transactionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class transactionService {

    @Autowired
    private  AccountService accountService;

    @Autowired
    private bankAccountRepo bankAccountRepo;

    @Autowired
    private transactionRepo transactionRepo;

    public fundTransferResponse fundtransfer( fundTransferReq fundTransferRequest){
        bankAccount fromAcc = accountService.readBankAccount(fundTransferRequest.getFromAccount());

        bankAccount toAcc = accountService.readBankAccount(fundTransferRequest.getToAccount());

        validateBalance(fromAcc, fundTransferRequest.getAmount());

        String transactionId = internalFundTransfer(fromAcc, toAcc, fundTransferRequest.getAmount());

        return fundTransferResponse.builder().msg("transaction successfully completed")
                .transactionId(transactionId).build();
    }

    private String internalFundTransfer(bankAccount fromAcc, bankAccount toAcc, BigDecimal amount) {
        String transactionId = UUID.randomUUID().toString();

        bankAccountEntity fromBankAccEntity = bankAccountRepo.findByNumber(fromAcc.getNumber()).get();

        bankAccountEntity toBankAccEntity = bankAccountRepo.findByNumber(toAcc.getNumber()).get();

        fromBankAccEntity.setActualBalance(fromBankAccEntity.getActualBalance().subtract(amount));

        fromBankAccEntity.setAvailableBalance(fromBankAccEntity.getActualBalance().subtract(amount));

        bankAccountRepo.save(fromBankAccEntity);

        transactionRepo.save(transactionEntity.builder().transactionType(transactionType.FUND_TRANSFER)
                .referenceNumber(toBankAccEntity.getNumber())
                .transactionId(
                        transactionId
                )
                .account(
                        fromBankAccEntity
                )
                .amount(amount.negate()).build()
        );

        toBankAccEntity.setActualBalance(toBankAccEntity.getActualBalance().add(amount
        ));

        toBankAccEntity.setAvailableBalance(toBankAccEntity.getActualBalance().add(amount));

        bankAccountRepo.save(toBankAccEntity);

        transactionRepo.save(
                transactionEntity.builder().transactionType(transactionType.FUND_TRANSFER)
                        .referenceNumber(toBankAccEntity.getNumber())
                        .transactionId(transactionId)
                        .account(toBankAccEntity)
                        .amount(amount).build()
        );

        return transactionId;
    }

    private void validateBalance(bankAccount fromAcc, BigDecimal amount) {

        if(fromAcc.getActualBalance().compareTo(BigDecimal.ZERO) < 0 || fromAcc.getActualBalance().compareTo(amount) <0)
        {
            throw new RuntimeException();
        }
    }

    public utilityPaymentResponse utilityPaymentRes(utilityPaymentReq utilityPaymentRequest)
    {
        String transactionId = UUID.randomUUID().toString();

        bankAccount fromBankAcc = accountService.readBankAccount(
                utilityPaymentRequest.getAccount()
        );

        validateBalance(fromBankAcc, utilityPaymentRequest.getAmount());

        utilityAccount utilityAccount = accountService.readUtilityAccount(
                utilityPaymentRequest.getProviderId()
        );

        bankAccountEntity fromAcc = bankAccountRepo.findByNumber(fromBankAcc.getNumber()).get();

        fromAcc.setActualBalance(fromAcc.getActualBalance().subtract(utilityPaymentRequest.getAmount()));

        fromAcc.setActualBalance(fromAcc.getActualBalance().subtract(
                utilityPaymentRequest.getAmount()
        ));

        transactionRepo.save(

                transactionEntity.builder()
                        .transactionType(transactionType.UTILITY_PAYMENT)
                        .account(fromAcc)
                        .transactionId(transactionId)
                        .referenceNumber(utilityPaymentRequest.getReferenceNum())
                        .amount(utilityPaymentRequest.getAmount().negate())
                        .build()

        );

        return utilityPaymentResponse.builder().
                msg("utility payment successfully completed")
                .trandactionId(transactionId)
                .build();
    }



}
