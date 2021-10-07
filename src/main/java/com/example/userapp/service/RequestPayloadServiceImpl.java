package com.example.userapp.service;

import com.example.userapp.domain.User;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.service.dto.*;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;

/**
 * A Service  Implementation Class  for User.
 */
@Transactional
@Service
@RequiredArgsConstructor
public class RequestPayloadServiceImpl implements RequestPayloadService {
    private final ChildUserService childUserService;
    private final ParentUserService parentUserService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public Optional<? extends BaseDTO> create(@Valid RequestPayload payload) throws InvalidValueException {
        UserDTO userDTO = modelMapper.map(payload, UserDTO.class);
        if (userRepository.checkUniqueEmail(payload.getEmail()) > 0) {
            throw new InvalidValueException("This  Email has been already used.Try again with another email");
        }else{
            if (payload.isChild()) {
                if (payload.getParentId() == null) {
                    throw new InvalidValueException("This user's parent id is missing!");
                }
                final ChildUserDTO childUserDTO = new ChildUserDTO();
                childUserDTO.setUser(userDTO);
                childUserDTO.setParentId(payload.getParentId());
                return childUserService.createChildUser(childUserDTO)
                        .map(chUser -> modelMapper.map(chUser, ChildUserDTO.class));
            } else {
                ParentUserDTO parentUserDTO = new ParentUserDTO();
                parentUserDTO.setUser(userDTO);
                parentUserDTO.setAddress(payload.getAddress());
                return parentUserService.createParentUser(parentUserDTO).map(p -> modelMapper.map(p, ParentUserDTO.class));
            }
        }

    }

    @Override
    public Optional<? extends BaseDTO> update(@Valid RequestPayload payload) throws InvalidValueException, UserNotFoundException {
        if (payload.getUserId()==null) {
            throw new InvalidValueException("User Id is missing! Please provide userId's valid value");
        }else{
            User user=userRepository.findById(payload.getUserId()).orElse(null);
            if(user==null){
                throw new UserNotFoundException("User Not Found with this userId");
            }
            UserDTO userDTO = modelMapper.map(payload, UserDTO.class);
            userDTO.setId(payload.getUserId());
            if (payload.isChild()) {
                final ChildUserDTO childUserDTO = new ChildUserDTO();
                childUserDTO.setUser(userDTO);
                childUserDTO.setParentId(payload.getParentId());
                return childUserService.updateChildUser(childUserDTO)
                        .map(chUser -> modelMapper.map(chUser, ChildUserDTO.class));
            } else {
                ParentUserDTO parentUserDTO = new ParentUserDTO();
                parentUserDTO.setUser(userDTO);
                parentUserDTO.setAddress(payload.getAddress());
                return parentUserService.updateParentUser(parentUserDTO).map(p -> modelMapper.map(p, ParentUserDTO.class));
            }

        }

    }


}
