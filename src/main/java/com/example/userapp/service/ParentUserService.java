package com.example.userapp.service;

import com.example.userapp.domain.ParentUser;
import com.example.userapp.service.dto.ParentUserDTO;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;

import java.util.List;
import java.util.Optional;
/**
 * A Service  Interface Class  for Parent type user.
 */

public interface ParentUserService {

    Optional<ParentUser> createParentUser(ParentUserDTO parentUser) throws InvalidValueException;

    Optional<ParentUser> updateParentUser (ParentUserDTO parentUserDTO) throws InvalidValueException, UserNotFoundException;

    Optional<ParentUser> findParentUserById(Long id);

    List<ParentUser> getAllParentUsers();

}
