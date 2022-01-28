package com.korayaks.springbootproject.utils.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDto {
    @NotNull(message = "'firstName' may not be null")
    @Size(max = 30, message = "'firstName' field can be maximum 30 characters.")
    private String firstName;
    @NotBlank(message = "'lastName' may not be null.")
    @Size(max = 30, message = "'lastName' field can be maximum 30 characters.")
    private String lastName;
    @NotNull(message = "'address' may not be null.")
    @Size(max = 200, message = "'address' field can be maximum 200 characters.")
    private String address;
    @NotNull(message = "'age' may not be null.")
    @Size(max = 3, message = "'age' field can be maximum 3 characters.")
    private String age;
}
