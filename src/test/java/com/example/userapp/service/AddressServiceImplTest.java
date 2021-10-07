package com.example.userapp.service;

import com.example.userapp.UserappApplication;
import com.example.userapp.domain.Address;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = UserappApplication.class)
public class AddressServiceImplTest {
    private static final String DEFAULT_STATE = "STATE";
    private static final String DEFAULT_CITY = "CITY";
    private static final String DEFAULT_ZIP = "ZIP";
    private static final String DEFAULT_STREET = "STREET";
    @Mock
    AddressServiceImpl addressServiceImpl;

    @Test
    @DisplayName("Should Retrieve Address by Id")
    public void testShouldFindAddressById() {
        Address address = new Address(1l, DEFAULT_STATE, DEFAULT_CITY, DEFAULT_ZIP, DEFAULT_STREET);
        Address expectedAddressResponse = address;
        Mockito.when(addressServiceImpl.findAddressById(1l)).thenReturn(Optional.of(expectedAddressResponse));
        Assertions.assertThat(address.getId()).isEqualTo(expectedAddressResponse.getId());
    }

}
