package com.cbrk.micro.service.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user-home")
    public String homePage(@AuthenticationPrincipal OidcUser user) {
        return "Welcome "+user.getFullName() + "!";
    }
}
