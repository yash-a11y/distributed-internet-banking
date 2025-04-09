package com.yas.Banking_user_service.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class keycloakProperties {

    @Value("${app.config.keycloak.server-url}")
    private String serverUrl;

    @Getter
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
                keycloakInstance = KeycloakBuilder.builder()
                        .serverUrl(serverUrl)
                        .realm("master")  // Use master realm for admin operations
                        .grantType("password")
                        .username("admin") // Keycloak admin username
                        .password("admin") // Keycloak admin password
                        .clientId("admin-cli")
                        .build();
                
                // Test the connection
                keycloakInstance.realm(realm).toRepresentation();
                log.info("Successfully connected to Keycloak server at {}", serverUrl);
            } catch (Exception e) {
                log.error("Failed to connect to Keycloak server: {}", e.getMessage());
                throw new RuntimeException("Could not connect to Keycloak server: " + e.getMessage(), e);
            }
        }
        return keycloakInstance;
    }
}
