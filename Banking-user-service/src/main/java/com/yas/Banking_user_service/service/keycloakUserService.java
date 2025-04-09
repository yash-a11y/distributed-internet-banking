package com.yas.Banking_user_service.service;


import com.yas.Banking_user_service.config.keycloakManager;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import jakarta.ws.rs.core.Response;
import java.util.List;

@Service
@RequiredArgsConstructor
public class keycloakUserService {

    private final keycloakManager keycloakManager;

    public Integer createUser(UserRepresentation userRepresentation)
    {
        Response response = keycloakManager.getInstanceWithRealm().users()
                .create(userRepresentation);
        return response.getStatus();
    }

    public void updateUser(UserRepresentation userRepresentation){
        keycloakManager.getInstanceWithRealm().users().get(userRepresentation.getId())
                .update(userRepresentation
                );
    }

    public List<UserRepresentation> readUserByEmail(String email)
    {
        return keycloakManager.getInstanceWithRealm().users().search(email);
    }

    public UserRepresentation readUser(String authID)
    {
        try{
        return keycloakManager.getInstanceWithRealm().users().get(authID)
                .toRepresentation();}
        catch (Exception e){
            throw new RuntimeException("under given ID, user not found!");
        }
    }
}
