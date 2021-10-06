package com.example.userapp.web.rest;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class BaseRestController {
    protected <K> ResponseEntity<K> response(Optional<K> optionalData) {
        return optionalData.map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(null));
    }
}
