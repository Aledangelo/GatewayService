package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    protected SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and().logout().logoutUrl("/logout")
                .and()
                .oauth2Login()
                .and().csrf().disable();

        return http.build();
    }
}
