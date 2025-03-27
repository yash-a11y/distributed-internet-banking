package com.yash.core_banking_service.mapper;

import com.yash.core_banking_service.DTO.bankAccount;
import com.yash.core_banking_service.models.bankAccountEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class bankAccountMapper extends mapper<bankAccountEntity, bankAccount>{

    @Override
    public bankAccountEntity convertToEntity(bankAccount dto, Object... args) {

        bankAccountEntity entity = new bankAccountEntity();
        if(dto != null)
        {
            BeanUtils.copyProperties(dto, entity, "user");
        }
        return entity;
    }

    @Override
    public bankAccount convertToDto(bankAccountEntity entity, Object... args) {
        bankAccount dto = new bankAccount();
        if(entity != null)
        {
            BeanUtils.copyProperties(entity, dto, "user");
        }
        return dto;
    }
}
