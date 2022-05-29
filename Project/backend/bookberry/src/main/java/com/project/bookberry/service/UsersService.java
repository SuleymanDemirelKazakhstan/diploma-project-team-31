package com.project.bookberry.service;

import com.project.bookberry.dto.LoginRequestDTO;
import com.project.bookberry.dto.RegistrationParameters;
import com.project.bookberry.dto.UserDTO;
import com.project.bookberry.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService {
    Users findUserByEmail(String email);
    Users save(Users user);
    UserDTO create(RegistrationParameters registrationParameters);
    boolean signIn(LoginRequestDTO loginRequestDTO);
    Users getCurrentUser();
}
