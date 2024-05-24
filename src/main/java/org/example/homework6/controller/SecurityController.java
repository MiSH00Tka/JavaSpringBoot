package org.example.homework6.controller;


import org.example.homework6.dto.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/public/api")
    public UserDetails publicApi(Authentication authentication) {
        return new UserDetails(authentication.getName(), authentication.getAuthorities().toString());
    }

    @GetMapping("/admin/api")
    public UserDetails adminApi(Authentication authentication) {
        return new UserDetails(authentication.getName(), authentication.getAuthorities().toString());
    }

    @GetMapping("/support/api")
    public UserDetails supportApi(Authentication authentication) {
        return new UserDetails(authentication.getName(), authentication.getAuthorities().toString());
    }
}
