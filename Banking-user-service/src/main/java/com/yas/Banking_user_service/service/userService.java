package com.yas.Banking_user_service.service;

import com.yas.Banking_user_service.exception.GlobalErrorCode;
import com.yas.Banking_user_service.exception.invalidUserException;
import com.yas.Banking_user_service.mapper.userMapper;
import com.yas.Banking_user_service.model.dto.status;
import com.yas.Banking_user_service.model.dto.user;
import com.yas.Banking_user_service.model.dto.userUpdateReq;
import com.yas.Banking_user_service.model.entity.userEntity;
import com.yas.Banking_user_service.model.repo.userRepo;
import com.yas.Banking_user_service.model.response.userResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class userService {

    private final keycloakUserService keycloakUserService;
    private final userRepo userRepository;

    private final bankingCoreClient bankingCoreClient;


    private userMapper userMapper = new userMapper();

    public user createUser(user user)
    {
        List<UserRepresentation> userRepresentationList = keycloakUserService.readUserByEmail(
                user.getEmail()
        );

        if(userRepresentationList.size() > 0)
        {
            throw new invalidUserException(
                    "This email already registered as a user. Please check and retry.", GlobalErrorCode.ERROR_EMAIL_REGISTERED);
        }

        userResponse userResponse = bankingCoreClient.readUser(user.getIdentification());

        if(userResponse.getId() != null)
        {
            if(!userResponse.getEmail().equals(user.getEmail())){
                throw new invalidUserException("Incorrect email. Please check and retry.", GlobalErrorCode.ERROR_INVALID_EMAIL);
            }
        }

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(userResponse.getEmail());
        userRepresentation.setEmailVerified(false);
        userRepresentation.setEnabled(false);
        userRepresentation.setUsername(userResponse.getEmail());

        CredentialRepresentation credentialRepresentation=
                new CredentialRepresentation();
        credentialRepresentation.setValue(user.getPassword());
        credentialRepresentation.setTemporary(false);

        userRepresentation.setCredentials(Collections.singletonList(
                credentialRepresentation
        ));

        Integer creationRes = keycloakUserService.createUser(userRepresentation);

        if(creationRes == 201){
            log.info(
                    "user created : {}",user.getEmail()
            );

            List<UserRepresentation> userRepresentations1 =
                    keycloakUserService.readUserByEmail(user.getEmail());

            user.setAuthId(userRepresentations1.get(0).getId());
            user.setStatus(status.PENDING.toString());
            user.setIdentification(userResponse.getIdentificationNumber());

            userEntity  userEntitySave = userRepository.save(
                    userMapper.convertToEntity(user)
            );

            return userMapper.convertToDto(userEntitySave);
        }

        throw new invalidUserException("We couldn't find user under given identification. Please check and retry", GlobalErrorCode.ERROR_USER_NOT_FOUND_UNDER_NIC);

    }

    //from where pageable comes and what is it.
    public List<user> readUsers(Pageable pageable){
        Page<userEntity> allUserInDB = userRepository.findAll(
                pageable
        );
        List<user> users = userMapper.convertToDtoList(allUserInDB.getContent());

        users.forEach(
                user -> {
                    UserRepresentation userRepresentation = keycloakUserService.readUser(user.getAuthId());

                    user.setId(user.getId());
                    user.setEmail(userRepresentation.getEmail());
                    user.setIdentification(user.getIdentification());
                }
        );

        return users;
    }

    public user readUser(Long userID)
    {
        user userdto = userMapper.convertToDto(
                userRepository.findById(userID).orElseThrow(
                        EntityNotFoundException::new
                )

        );
    return userdto;
    }

    public user updateUser(Long id, userUpdateReq userUpdateRequest)
    {
        userEntity userEntity = userRepository.findById(id).orElseThrow(
                EntityNotFoundException::new
        );
        if(userUpdateRequest.getStatus() == status.APPROVED){
            UserRepresentation userRepresentation = keycloakUserService.readUser(
                    userEntity.getAuthId()
            );

            userRepresentation.setEnabled(true);
            userRepresentation.setEmailVerified(true);
            keycloakUserService.updateUser(userRepresentation);
        }


        userEntity.setStatus(userUpdateRequest.getStatus());

        return userMapper.convertToDto(userRepository.save(userEntity));
    }

}
