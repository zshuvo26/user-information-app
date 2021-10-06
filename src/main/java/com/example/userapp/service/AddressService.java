package com.example.userapp.service;

import com.example.userapp.domain.Address;
import com.example.userapp.service.dto.AddressDTO;
import com.example.userapp.web.rest.errors.UserNotFoundException;

import java.util.Optional;
/**
 * A Service Interface for Address.
 */

public interface AddressService {
    Optional<Address> createAddress(AddressDTO address);

    Optional<Address> updateAddress(AddressDTO address);

    Optional<Address> findAddressById(Long id);

    void deleteAddress(Long id) throws UserNotFoundException;

}
