package com.example.userapp.service;

import com.example.userapp.service.dto.BaseDTO;
import com.example.userapp.service.dto.RequestPayload;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;
/**
 * A Service  Interface   for Creating User.
 */

@Validated
public interface RequestPayloadService {

    Optional<? extends BaseDTO> create(@Valid RequestPayload payload) throws InvalidValueException;

    Optional<? extends BaseDTO> update(@Valid RequestPayload payload) throws InvalidValueException, UserNotFoundException;

}
