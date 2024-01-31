package com.wintech.wtoauth.controllers;

import com.wintech.wtoauth.domains.User;
import com.wintech.wtoauth.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AuthorizationController {

    @Autowired
    private AuthorizationService service;

    @GetMapping("/search")
    public ResponseEntity<User> findUser(@RequestParam String username){
        User user = service.findUser(username);
        return ResponseEntity.ok(user);
    }

}
