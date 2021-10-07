package com.example.userapp.web.rest;

import com.example.userapp.service.ChildUserService;
import com.example.userapp.service.dto.ChildUserDTO;
import com.example.userapp.web.rest.errors.InvalidDeleteException;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChildUserRestController extends BaseRestController {
    private final ChildUserService childUserService;
    private final ModelMapper modelMapper;

    @PostMapping("/child-users")
    public ResponseEntity<ChildUserDTO> createChild(@Valid @RequestBody ChildUserDTO childUserDTO) throws InvalidValueException {
        return response(childUserService.createChildUser(childUserDTO)
                .map(childUser -> modelMapper.map(childUser, ChildUserDTO.class)));
    }
    //Delete Child User by ID
    @DeleteMapping("/child-users/{id}")
    public void deleteChildUser(@PathVariable Long id) throws UserNotFoundException, InvalidValueException {
        childUserService.deleteChildUser(id);
    }
}
