package com.example.userapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A DTO representing a parent type user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentUserDTO extends BaseDTO {
    private AddressDTO address;
    private UserDTO user;

    @Override
    public String toString() {
        return "ParentUserDTO{" +
                "address=" + address +
                ", user=" + user +
                '}';
    }
}
