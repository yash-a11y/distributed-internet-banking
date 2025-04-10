package com.yas.Banking_user_service.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class keycloakProperties {

    @Value("${app.config.keycloak.server-url}")
    private String serverUrl;


    @Value("${app.config.keycloak.realm}")
    private String realm;

    @Value("${app.config.keycloak.clientId}")
    private String clientId;

    @Value("${app.config.keycloak.client-secret}")
    private String clientSecret;

    private static Keycloak keycloakInstance = null;

    public Keycloak getKeycloakInstance() {
        if(keycloakInstance == null) {
            try {
                log.info("Initializing Keycloak connection with settings:");
                log.info("Server URL: {}", serverUrl);
                log.info("Realm: {}", realm);
                log.info("Client ID: {}", clientId);
                log.info("Client Secret: {}", clientSecret != null ? "provided" : "missing");
                
                keycloakInstance = KeycloakBuilder.builder()
                        .serverUrl(serverUrl)
                        .realm(realm)
                        .grantType("client_credentials")
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .build();

                // Test the connection
                try {
                    keycloakInstance.realm(realm).toRepresentation();
                    log.info("Successfully connected to Keycloak and verified realm access");
                } catch (Exception e) {
                    log.error("Failed to access realm after connection: {}", e.getMessage());
                    throw e;
                }
            } catch (Exception e) {
                log.error("Failed to initialize Keycloak connection: {}", e.getMessage());
                throw new RuntimeException("Could not connect to Keycloak server: " + e.getMessage(), e);
            }
        }
        return keycloakInstance;
    }

    public String getRealm(){
        return realm;
    }
}
