package com.yash.utility_payment_service.model.mapper;



import com.yash.utility_payment_service.model.dto.utilityPayment;
import com.yash.utility_payment_service.model.entity.utilityPaymentEntity;
import org.springframework.beans.BeanUtils;

import java.beans.Beans;

public class utilityPaymentMapper extends mapper<utilityPaymentEntity, utilityPayment> {
    @Override
    public utilityPaymentEntity convertToEntity(utilityPayment dto, Object... args) {
        utilityPaymentEntity entity = new utilityPaymentEntity();

        if(dto != null)
        {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public utilityPayment convertToDto(utilityPaymentEntity entity, Object... args) {

        utilityPayment dto = new utilityPayment();

        if(entity != null)
        {
          BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}
