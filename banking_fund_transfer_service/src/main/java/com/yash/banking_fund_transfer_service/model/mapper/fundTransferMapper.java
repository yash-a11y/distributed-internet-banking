package com.yash.banking_fund_transfer_service.model.mapper;

import com.yash.banking_fund_transfer_service.model.dto.fundTransfer;
import com.yash.banking_fund_transfer_service.model.entity.fundTransferEntity;
import org.springframework.beans.BeanUtils;

public class fundTransferMapper extends mapper<fundTransferEntity, fundTransfer>
{

    @Override
    public fundTransferEntity convertToEntity(fundTransfer dto, Object... args) {
        fundTransferEntity entity = new fundTransferEntity();
        if(dto != null)
        {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public fundTransfer convertToDto(fundTransferEntity entity, Object... args) {
        fundTransfer dto = new fundTransfer();
        if(entity != null)
        {
            BeanUtils.copyProperties(

                    entity, dto
            );
        }
        return dto;
    }


}
