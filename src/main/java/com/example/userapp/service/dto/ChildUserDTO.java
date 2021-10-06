package com.example.userapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A DTO representing a user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildUserDTO extends BaseDTO {
    private Long parentId;

    private UserDTO user;
}
