package com.yash.core_banking_service.mapper;

import com.yash.core_banking_service.DTO.utilityAccount;
import com.yash.core_banking_service.models.utilityAccountEntity;
import org.springframework.beans.BeanUtils;

public class utilityAccMapper extends mapper<utilityAccountEntity, utilityAccount> {

    @Override
    public utilityAccountEntity convertToEntity(utilityAccount dto, Object... args) {
        utilityAccountEntity entity = new utilityAccountEntity();

        if(dto != null)
        {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public utilityAccount convertToDto(utilityAccountEntity entity, Object... args) {
        utilityAccount dto = new utilityAccount();
        if(entity != null)
        {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}
