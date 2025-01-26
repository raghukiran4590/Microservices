package com.cbrk.micro.service.controller;

import com.cbrk.micro.service.model.AuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login (
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model) {

        log.info("user email id : {} ", user.getEmail());

        //creating auth response object
        AuthResponse authResponse = new AuthResponse();

        //setting email to AuthRepsonse
        authResponse.setUserId(user.getEmail());

        //setting toke to auth response
        authResponse.setAccessToken(client.getAccessToken().getTokenValue());

        authResponse.setRefreshToken(Objects.requireNonNull(client.getRefreshToken()).getTokenValue());

        authResponse.setExpireAt(Objects.requireNonNull(client.getAccessToken().getExpiresAt()).getEpochSecond());

        List<String> authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        authResponse.setAuthorities(authorities);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);

    }

    @GetMapping("/user-home")
    public String homePage(@AuthenticationPrincipal OidcUser user) {
        return "Welcome "+user.getFullName() + "!";
    }

}
