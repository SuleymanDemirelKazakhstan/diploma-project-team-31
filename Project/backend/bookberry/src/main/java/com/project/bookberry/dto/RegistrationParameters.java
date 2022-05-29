package com.project.bookberry.dto;

import lombok.Data;

@Data
public class RegistrationParameters {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String mobileNumber;
    private String lastName;
    private String city;
    private String address;
}
