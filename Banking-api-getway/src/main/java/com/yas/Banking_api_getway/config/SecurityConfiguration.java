package com.yas.Banking_api_getway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges -> exchanges
                        //ALLOWING REGISTER API FOR DIRECT ACCESS
                        .pathMatchers("/user/api/v1/bank-user/register").permitAll()
                        //ALL OTHER APIS ARE AUTHENTICATED
                        .anyExchange().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .oauth2Login(oauth2Login -> {})
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {})
                )
                .build();
    }
}