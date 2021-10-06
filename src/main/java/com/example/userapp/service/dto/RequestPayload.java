package com.example.userapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * A DTO representing a for creating and updating User.
 */
@Getter
@Setter
@NoArgsConstructor
public class RequestPayload extends BaseDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    @Email
    @NotNull(message = "Email address  cannot be empty.")
    private String email;
    private boolean child;
    private Long parentId;
    private AddressDTO address;

}
