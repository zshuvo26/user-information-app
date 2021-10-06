package com.example.userapp.web.rest;

import com.example.userapp.service.RequestPayloadService;
import com.example.userapp.service.dto.BaseDTO;
import com.example.userapp.service.dto.RequestPayload;
import com.example.userapp.web.rest.errors.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class RequestPayloadRestController extends BaseRestController {
    private final RequestPayloadService requestPayloadService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<? extends BaseDTO> create(@RequestBody RequestPayload payload) throws InvalidValueException {
        if (payload.getEmail().isEmpty() || payload.getFirstName().isEmpty()) {
            throw new InvalidValueException("Email and First Name both should be given");
        }
        return response(requestPayloadService.create(payload));
    }

    @PutMapping
    public ResponseEntity<? extends BaseDTO> update(@RequestBody RequestPayload payload)  throws InvalidValueException{
        return response(requestPayloadService.update(payload));
    }


}
