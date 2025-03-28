package com.yash.core_banking_service.service;

import com.yash.core_banking_service.DTO.User;
import com.yash.core_banking_service.mapper.userMapper;
import com.yash.core_banking_service.models.userEntity;
import com.yash.core_banking_service.repository.userRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class userService {
    private userMapper usermapper = new userMapper();


    @Autowired
    private userRepo userRepository;

    public User readUser(String identify)
    {
        userEntity userentity = userRepository.findByIdentificationNumber(identify
        ).get();

        return usermapper.convertToDto(userentity);

    }

    public List<User> readUsers(Pageable pageable){
        return usermapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }


}
