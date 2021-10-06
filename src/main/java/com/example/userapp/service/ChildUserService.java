package com.example.userapp.service;

import com.example.userapp.domain.ChildUser;
import com.example.userapp.service.dto.ChildUserDTO;
import com.example.userapp.web.rest.errors.InvalidValueException;

import java.util.Optional;

/**
 * A Service  Interface Class  for Child Type User.
 */

public interface ChildUserService {
    Optional<ChildUser> createChildUser(ChildUserDTO childUser) throws InvalidValueException;

    Optional<ChildUser> updateChildUser(ChildUserDTO childUserDTO) throws InvalidValueException;
}
