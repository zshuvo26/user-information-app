package com.example.userapp.service;

import com.example.userapp.domain.Address;
import com.example.userapp.repository.AddressRepository;
import com.example.userapp.service.dto.AddressDTO;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * A Service  Implementation Class  for Address.
 */

@Transactional
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    @Override
    public Optional<Address> createAddress(AddressDTO address) {
        return Optional.of(addressRepository.findAddressByStreetAndZipAndCityAndState(
                address.getStreet(),
                address.getZip(),
                address.getCity(),
                address.getState()
        ).orElseGet(() -> addressRepository.save(modelMapper.map(address, Address.class))));

    }

    @Override
    public Optional<Address> updateAddress(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        return Optional.of(addressRepository.save(address));
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void deleteAddress(Long id) throws UserNotFoundException {
        addressRepository.deleteById(id);
    }
}
