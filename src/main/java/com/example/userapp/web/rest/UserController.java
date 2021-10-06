package com.example.userapp.web.rest;


import com.example.userapp.domain.User;
import com.example.userapp.service.RequestPayloadService;
import com.example.userapp.service.UserService;
import com.example.userapp.service.dto.RequestPayload;
import com.example.userapp.web.rest.errors.InvalidDeleteException;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RequestPayloadService requestPayloadService;


    //Fetch All User
    @GetMapping
    public ArrayList<RequestPayload> getAllUsers() {
        return userService.getAllUsers();
    }

    //Fetch User by ID
    @GetMapping("/{id}")
    public RequestPayload getUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    //Delete User by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException, InvalidValueException, InvalidDeleteException {
        userService.deleteUser(id);
    }
}
