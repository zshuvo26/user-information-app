package com.example.userapp.service.dto;


import lombok.Data;
/**
 * A DTO representing  user's address.
 */

@Data
public class AddressDTO {
    private Long id;
    private String state;
    private String city;
    private String zip;
    private String street;


    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
