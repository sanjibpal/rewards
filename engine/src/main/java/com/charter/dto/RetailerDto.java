package com.charter.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class RetailerDto {
    private String firstName;
    private String lastName;
    @NotEmpty(message="Email/Username can't be empty")
    private String email;
    @NotEmpty(message="Password can't be empty")
    private String password;
}
