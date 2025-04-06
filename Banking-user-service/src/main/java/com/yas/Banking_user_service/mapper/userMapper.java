package com.yas.Banking_user_service.mapper;

import com.yas.Banking_user_service.model.dto.user;
import com.yas.Banking_user_service.model.entity.userEntity;
import org.springframework.beans.BeanUtils;


public class userMapper extends mapper<userEntity, user>{
    @Override
    public userEntity convertToEntity(user dto, Object... args) {
        userEntity userEntity = new userEntity();
        if(dto != null)
        {
            BeanUtils.copyProperties(
                    dto,userEntity
            );
        }
        return userEntity;
    }

    @Override
    public user convertToDto(userEntity entity, Object... args) {
        user userdto = new user();
        if(entity!= null)
        {
            BeanUtils.copyProperties(entity,userdto);
        }
        return userdto;
    }
}
