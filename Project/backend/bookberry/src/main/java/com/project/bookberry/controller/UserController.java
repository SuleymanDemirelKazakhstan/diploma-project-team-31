package com.project.bookberry.controller;

import com.project.bookberry.entity.Users;
import com.project.bookberry.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/current-user")
    public ResponseEntity<Users> getCurrentUser(Authentication authentication){
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Users userByEmail = usersService.findUserByEmail(principal.getUsername());
        return ResponseEntity.ok(userByEmail);
    }
}
