package com.example.userapp.web.rest;

import com.example.userapp.service.RequestPayloadService;
import com.example.userapp.service.dto.BaseDTO;
import com.example.userapp.service.dto.RequestPayload;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RequestPayloadRestController extends BaseRestController {
    private final RequestPayloadService requestPayloadService;
    /**
     * POST  /users  : Creates a new user.
     * Creates a new user if  email is not already used, and sends
     * @return the ResponseEntity with status 201 (Created) and with body the new user, or with status 400 (Bad Request)
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<? extends BaseDTO> create(@RequestBody RequestPayload payload) throws InvalidValueException {
        if (payload.getEmail().isEmpty() || payload.getFirstName().isEmpty()) {
            throw new InvalidValueException("Email and First Name both should be given");
        }
        return response(requestPayloadService.create(payload));
    }

    /**
     * PUT /users : Updates an existing User.
     *
     * @return the ResponseEntity with status 200 (OK) and with body the updated user
     * @throws InvalidValueException 400 (Bad Request) if the userId is null or invalid
     * @throws UserNotFoundException  if the userId is  invalid
     */

    @PutMapping("/users")
    public ResponseEntity<? extends BaseDTO> update(@RequestBody RequestPayload payload)  throws InvalidValueException, UserNotFoundException {
        return response(requestPayloadService.update(payload));
    }

}
