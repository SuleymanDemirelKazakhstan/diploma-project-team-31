package com.project.bookberry.controller;

import com.project.bookberry.dto.LoginRequestDTO;
import com.project.bookberry.dto.LoginResponseDTO;
import com.project.bookberry.dto.RegistrationParameters;
import com.project.bookberry.dto.UserDTO;
import com.project.bookberry.security.service.SecurityService;
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
    @Autowired
    private SecurityService securityService;

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDTO> signIn(@RequestBody LoginRequestDTO loginRequestDTO){
        String token = securityService.authenticate(loginRequestDTO.getLogin(),
                loginRequestDTO.getPassword());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody RegistrationParameters registrationParameters){
        UserDTO user = usersService.create(registrationParameters);
        return ResponseEntity.ok(user);
    }
}
