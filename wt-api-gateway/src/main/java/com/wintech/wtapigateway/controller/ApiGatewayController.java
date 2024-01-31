package com.wintech.wtapigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class ApiGatewayController {

    @GetMapping
    public ResponseEntity<String> health(){
        return ResponseEntity.ok().body("Api Gateway rodando.");
    }
}
