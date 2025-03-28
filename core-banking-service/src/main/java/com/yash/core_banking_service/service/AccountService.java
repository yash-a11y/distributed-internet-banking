package com.yash.core_banking_service.service;

import com.yash.core_banking_service.DTO.bankAccount;
import com.yash.core_banking_service.DTO.utilityAccount;
import com.yash.core_banking_service.mapper.bankAccountMapper;
import com.yash.core_banking_service.mapper.utilityAccMapper;
import com.yash.core_banking_service.models.bankAccountEntity;
import com.yash.core_banking_service.models.utilityAccountEntity;
import com.yash.core_banking_service.repository.bankAccountRepo;
import com.yash.core_banking_service.repository.utilityAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private bankAccountMapper bankAccountmapper =  new bankAccountMapper();

    private utilityAccMapper utilityAccMapper = new utilityAccMapper();

    @Autowired
    private bankAccountRepo bankAccountRepository;

    @Autowired
    private utilityAccountRepo utilityAccountRepo;

    public bankAccount readBankAccount(String accNumber)
    {
        bankAccountEntity bankAccountentity = bankAccountRepository.findByNumber(accNumber).get();
        return bankAccountmapper.convertToDto(
                bankAccountentity
        );
    }

    public utilityAccount readutilityAccount(String provider)
    {

        utilityAccountEntity utilityAccountentity = utilityAccountRepo.findByProvidedName(provider).get();
        return utilityAccMapper.convertToDto(utilityAccountentity);

    }


    public utilityAccount readUtilityAccount(Long id)
    {
        return utilityAccMapper.convertToDto(utilityAccountRepo.findById(id).get());
    }
}

