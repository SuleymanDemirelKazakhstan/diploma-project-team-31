package com.project.bookberry.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String mobileNumber;
    private String lastName;
    private String city;
    private String address;
}
