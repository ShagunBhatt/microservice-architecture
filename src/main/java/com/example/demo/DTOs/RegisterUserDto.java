package com.example.demo.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String email;

    private String password;

    private String name;

    private String fullName;

    private String address;

    private String role;
}
