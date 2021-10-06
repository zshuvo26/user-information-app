package com.example.userapp.service;

import com.example.userapp.domain.ChildUser;
import com.example.userapp.repository.ChildUserRepository;
import com.example.userapp.service.dto.ChildUserDTO;
import com.example.userapp.web.rest.errors.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * A Service  Implementation Class  for Child Type User.
 */

@Transactional
@Service
@RequiredArgsConstructor
public class ChildUserServiceImpl implements ChildUserService {
    private final ChildUserRepository childUserRepository;
    private final UserService userService;
    private final ParentUserService parentUserService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Optional<ChildUser> createChildUser(ChildUserDTO childUser) throws InvalidValueException {
        ChildUser chUser = new ChildUser();
        chUser.setUser(userService.createUser(childUser.getUser()).orElseThrow(() -> new InvalidValueException("Can't create user")));
        chUser.setParentUser(parentUserService.findParentUserById(childUser.getParentId()).orElseThrow(() -> new InvalidValueException("Can't find parent by id")));
        return Optional.of(childUserRepository.saveAndFlush(chUser));
    }

    @Override
    public Optional<ChildUser> updateChildUser(ChildUserDTO childUserDTO) throws InvalidValueException {
        ChildUser chUser = childUserRepository.findByUserId(childUserDTO.getUser().getId());
        chUser.setUser(userService.updateUser(childUserDTO.getUser()).orElseThrow(() -> new InvalidValueException("Can't create user")));
        chUser.setParentUser(parentUserService.findParentUserById(childUserDTO.getParentId()).orElseThrow(() -> new InvalidValueException("Can't find parent by id")));
        return Optional.of(childUserRepository.saveAndFlush(chUser));
    }


}
