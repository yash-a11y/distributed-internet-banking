package com.yash.core_banking_service.mapper;

import com.yash.core_banking_service.DTO.User;
import com.yash.core_banking_service.models.userEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class userMapper extends  mapper<userEntity, User>{

    private bankAccountMapper bankAccountMapper = new bankAccountMapper();

    @Override
    public userEntity convertToEntity(User dto, Object... args) {
        userEntity userEntity = new userEntity();
        if(dto != null){
            BeanUtils.copyProperties(dto,userEntity,"accounts");

            userEntity.setBankAccounts(
                    bankAccountMapper.convertToEntityList(dto.getBankAccounts())
            );
        }
        return userEntity;
    }

    @Override
    public User convertToDto(userEntity entity, Object... args) {
        User dto = new User();

        if(entity!= null)
        {
            BeanUtils.copyProperties(entity,dto,"accounts");
            dto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getBankAccounts()));
        }
        return dto;
    }
}
