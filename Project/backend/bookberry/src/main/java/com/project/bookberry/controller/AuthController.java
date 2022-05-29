package com.project.bookberry.controller;

import com.project.bookberry.dto.LoginRequestDTO;
import com.project.bookberry.dto.LoginResponseDTO;
import com.project.bookberry.dto.RegistrationParameters;
import com.project.bookberry.dto.UserDTO;
import com.project.bookberry.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDTO> signIn(@RequestBody LoginRequestDTO loginRequestDTO){
        boolean signedIn = usersService.signIn(loginRequestDTO);
        return ResponseEntity.ok(new LoginResponseDTO(signedIn));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody RegistrationParameters registrationParameters){
        UserDTO user = usersService.create(registrationParameters);
        return ResponseEntity.ok(user);
    }
}
