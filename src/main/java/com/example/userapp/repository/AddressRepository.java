package com.example.userapp.repository;

import com.example.userapp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findAddressByStreetAndZipAndCityAndState(String street, String zip, String city, String state);

    @Query("select address from Address address where address.id = :id")
    Address findAddressByParentId(@Param("id") Long id);
}
