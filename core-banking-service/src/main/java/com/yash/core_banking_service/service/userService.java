package com.yash.core_banking_service.service;

import com.yash.core_banking_service.DTO.User;
import com.yash.core_banking_service.mapper.userMapper;
import com.yash.core_banking_service.models.userEntity;
import com.yash.core_banking_service.repository.userRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class userService {
    private userMapper usermapper = new userMapper();



    private final userRepo userRepository;

    public User readUser(String identify)
    {
        userEntity userentity = userRepository.findByIdentificationNumber(identify
        ).orElseThrow(EntityNotFoundException::new);

        return usermapper.convertToDto(userentity);

    }

    public List<User> readUsers(Pageable pageable){
        return usermapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }


}
