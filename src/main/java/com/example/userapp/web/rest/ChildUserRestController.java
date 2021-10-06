package com.example.userapp.web.rest;

import com.example.userapp.service.ChildUserService;
import com.example.userapp.service.dto.ChildUserDTO;
import com.example.userapp.web.rest.errors.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/child-users")
@RequiredArgsConstructor
public class ChildUserRestController extends BaseRestController {
    private final ChildUserService childUserService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ChildUserDTO> createChild(@Valid @RequestBody ChildUserDTO childUserDTO) throws InvalidValueException {
        return response(childUserService.createChildUser(childUserDTO)
                .map(childUser -> modelMapper.map(childUser, ChildUserDTO.class)));
    }
}
