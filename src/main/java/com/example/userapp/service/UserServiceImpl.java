package com.example.userapp.service;

import com.example.userapp.domain.ChildUser;
import com.example.userapp.domain.ParentUser;
import com.example.userapp.domain.User;
import com.example.userapp.repository.ChildUserRepository;
import com.example.userapp.repository.ParentUserRepository;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.service.dto.AddressDTO;
import com.example.userapp.service.dto.RequestPayload;
import com.example.userapp.service.dto.UserDTO;
import com.example.userapp.web.rest.errors.InvalidDeleteException;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A Service  Implementation Class  for User.
 */
@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ParentUserRepository parentUserRepository;
    private final ChildUserRepository childUserRepository;
    private final AddressService addressService;

    @Override
    public String deleteUser(Long id) throws UserNotFoundException, InvalidValueException, InvalidDeleteException {
        if (id == null)
            throw new InvalidValueException("Invalid value for id");
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("This  User is Not Available");
        } else {
            Optional<ParentUser> parentU = parentUserRepository.findById(id);
            if (parentU.isPresent()) {

                if (childUserRepository.checkParent(id) > 0) {
                    throw new InvalidDeleteException("This Instance has Child Instances");
                }
                ParentUser parentUser = parentUserRepository.findParentUserByUserId(user.get().getId());
                addressService.deleteAddress(parentUser.getAddress().getId());
                parentUserRepository.deleteById(parentUser.getId());
            } else {
                ChildUser childUser = childUserRepository.findByUserId(user.get().getId());
                childUserRepository.deleteById(childUser.getId());
            }
            userRepository.deleteById(user.get().getId());
        }
        return "User Deleted Successfully";
    }

    @Override
    public Optional<User> updateUser(UserDTO user) {
        User user1 = userRepository.findById(user.getId()).orElseThrow(RuntimeException::new);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        return Optional.of(userRepository.save(user1));
    }

    @Override
    public Optional<User> createUser(UserDTO user) throws InvalidValueException {
        if (user.getEmail() == null || user.getEmail() == "") {
            throw new InvalidValueException("Email is mandatory.");
        }
        if (userRepository.checkUniqueEmail(user.getEmail()) > 0) {
            throw new InvalidValueException("This  Email has been already used.");
        }
        return Optional.of(userRepository.save(modelMapper.map(user, User.class)));
    }


    @Override
    public RequestPayload getUser(Long id) throws UserNotFoundException {
        RequestPayload requestPayload = new RequestPayload();
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("This  User is Not Available");
        }else{
            ParentUser parentUser = parentUserRepository.findParentUserByUserId(user.get().getId());
            requestPayload.setUserId(user.get().getId());
            requestPayload.setFirstName(user.get().getFirstName());
            requestPayload.setLastName(user.get().getLastName());
            requestPayload.setEmail(user.get().getEmail());
            AddressDTO addressDTO = modelMapper.map(parentUser.getAddress(), AddressDTO.class);
            requestPayload.setAddress(addressDTO);
        }
        return requestPayload;
    }

    @Override
    public ArrayList<RequestPayload> getAllUsers() {
        List<User> users = userRepository.findAll();
        ArrayList<RequestPayload> requestPayloads = new ArrayList<>();
        for (User user : users) {
            RequestPayload requestPayload = new RequestPayload();
            ParentUser parentUser = parentUserRepository.findParentUserByUserId(user.getId());
            requestPayload.setUserId(user.getId());
            requestPayload.setFirstName(user.getFirstName());
            requestPayload.setLastName(user.getLastName());
            requestPayload.setEmail(user.getEmail());
            if(parentUser!=null){
                AddressDTO addressDTO = modelMapper.map(parentUser.getAddress(), AddressDTO.class);
                requestPayload.setAddress(addressDTO);
            }
            requestPayloads.add(requestPayload);
        }
        return requestPayloads;

    }
}
