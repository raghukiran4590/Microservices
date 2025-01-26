package com.cbrk.micro.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain (ServerHttpSecurity serverHttpSecurity) {
         return serverHttpSecurity
                .authorizeExchange(exchanges -> exchanges
//                        .pathMatchers("/api/**").hasRole("ADMIN")
                        .anyExchange().authenticated()
                ).oauth2Client(Customizer.withDefaults()).build();
/*                 oauth2Client(oauth2 -> oauth2
                         .clientRegistrationRepository(new InMemoryReactiveClientRegistrationRepository())
                         .authorizedClientRepository(new WebSessionServerOAuth2AuthorizedClientRepository())
                 ).oauth2ResourceServer((oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec
                         .jwt(Customizer.withDefaults()))).build();*/
    }
}
