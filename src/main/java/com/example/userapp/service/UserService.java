package com.example.userapp.service;

import com.example.userapp.domain.User;
import com.example.userapp.service.dto.RequestPayload;
import com.example.userapp.service.dto.UserDTO;
import com.example.userapp.web.rest.errors.InvalidDeleteException;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A Service   Interface  for User.
 */
public interface UserService {

    String deleteUser(Long id) throws UserNotFoundException, InvalidValueException, InvalidDeleteException;

    Optional<User> updateUser(UserDTO user);

    Optional<User> createUser(UserDTO user) throws InvalidValueException;

    RequestPayload getUser(Long id) throws UserNotFoundException;

    ArrayList<RequestPayload> getAllUsers();
}
