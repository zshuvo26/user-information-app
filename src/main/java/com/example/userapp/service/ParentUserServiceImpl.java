package com.example.userapp.service;

import com.example.userapp.domain.Address;
import com.example.userapp.domain.ParentUser;
import com.example.userapp.repository.AddressRepository;
import com.example.userapp.repository.ParentUserRepository;
import com.example.userapp.service.dto.AddressDTO;
import com.example.userapp.service.dto.ParentUserDTO;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.ParentUserNotFoundException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class ParentUserServiceImpl implements ParentUserService {
    private final UserService userService;
    private final ParentUserRepository parentUserRepository;
    private final AddressRepository addressRepository;
    private final AddressService addressService;


    @Override
    public Optional<ParentUser> createParentUser(ParentUserDTO parentUser) throws InvalidValueException {
        ParentUser pUser = new ParentUser();
        pUser.setUser(userService.createUser(parentUser.getUser()).orElseThrow(() -> new InvalidValueException("Can't create user for parent.,")));
        pUser.setAddress(addressService.createAddress(parentUser.getAddress()).orElseThrow(() -> new InvalidValueException("Can't get or create address for parent")));
        return Optional.of(parentUserRepository.saveAndFlush(pUser));

    }

    @Override
    public Optional<ParentUser> updateParentUser(ParentUserDTO parentUserDTO) throws InvalidValueException, UserNotFoundException {
        ParentUser pUser = parentUserRepository.findParentUserByUserId(parentUserDTO.getUser().getId());
        pUser.setUser(userService.updateUser(parentUserDTO.getUser()).orElseThrow(() -> new InvalidValueException("Can't create user for parent.,")));
        Address address = addressRepository.findById(pUser.getAddress().getId()).get();
        AddressDTO addressDTO = parentUserDTO.getAddress();
        addressDTO.setId(address.getId());
        pUser.setAddress(addressService.updateAddress(addressDTO).orElseThrow(() -> new UserNotFoundException("Can't get or create address for parent")));
        return Optional.of(parentUserRepository.saveAndFlush(pUser));

    }

    @Override
    public Optional<ParentUser> findParentUserById(Long id) {
        return parentUserRepository.findById(id);
    }

    @Override
    public List<ParentUser> getAllParentUsers() {
        return parentUserRepository.findAll();
    }

    public ParentUser ParentUser(Long id) throws ParentUserNotFoundException {
        Optional<ParentUser> parentUser = parentUserRepository.findById(id);
        if (!parentUser.isPresent()) {
            throw new ParentUserNotFoundException("This Parent User is Not Available");
        }
        return parentUser.get();
    }

}
