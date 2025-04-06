package com.yas.Banking_user_service.config;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class keycloakManager {

    private final keycloakProperties keycloakProperties;

    public RealmResource getInstanceWithRealm(){
        return keycloakProperties.getKeycloakInstance().realm(
                keycloakProperties.getRealm()
        );

    }
}
