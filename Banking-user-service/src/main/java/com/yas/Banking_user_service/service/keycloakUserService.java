package com.yas.Banking_user_service.service;


import com.yas.Banking_user_service.config.keycloakManager;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class keycloakUserService {

    private final keycloakManager keycloakManager;

    public Integer createUser(UserRepresentation userRepresentation)
    {
        log.info("Creating user with email: {}", userRepresentation.getEmail());
        Response response = keycloakManager.getInstanceWithRealm().users()
                .create(userRepresentation);
        log.info("User creation response status: {}", response.getStatus());
        return response.getStatus();
    }

    public void updateUser(UserRepresentation userRepresentation){
        log.info("Updating user with ID: {}", userRepresentation.getId());
        try {
            keycloakManager.getInstanceWithRealm().users().get(userRepresentation.getId())
                    .update(userRepresentation);
            log.info("User updated successfully");
        } catch (Exception e) {
            log.error("Failed to update user: {}", e.getMessage());
            throw e;
        }
    }

    public List<UserRepresentation> readUserByEmail(String email)
    {
        log.info("Searching for user with email: {}", email);
        try {
            List<UserRepresentation> users = keycloakManager.getInstanceWithRealm().users().search(email);
            log.info("Found {} users with email {}", users.size(), email);
            return users;
        } catch (Exception e) {
            log.error("Failed to search user by email: {}", e.getMessage());
            throw e;
        }
    }

    public UserRepresentation readUser(String authID)
    {
        log.info("Reading user with auth ID: {}", authID);
        try{
            UserRepresentation user = keycloakManager.getInstanceWithRealm().users().get(authID)
                    .toRepresentation();
            log.info("Successfully retrieved user");
            return user;
        } catch (Exception e){
            log.error("Failed to read user: {}", e.getMessage());
            throw new RuntimeException("under given ID, user not found!");
        }
    }
}
