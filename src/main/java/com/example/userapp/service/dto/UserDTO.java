package com.example.userapp.service.dto;

import com.example.userapp.domain.ParentUser;
import com.example.userapp.domain.User;
import com.example.userapp.domain.Address;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * A DTO representing a user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    @Email
    @NotNull
    private String email;

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
