package com.project.bookberry.service.impl;

import com.project.bookberry.dto.LoginRequestDTO;
import com.project.bookberry.dto.RegistrationParameters;
import com.project.bookberry.dto.UserDTO;
import com.project.bookberry.entity.Roles;
import com.project.bookberry.entity.Users;
import com.project.bookberry.exception.BookberryException;
import com.project.bookberry.exception.EntityNotFoundException;
import com.project.bookberry.repo.RolesRepo;
import com.project.bookberry.repo.UsersRepo;
import com.project.bookberry.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public Users findUserByEmail(String email) {
        return usersRepo.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User with this email not found : " + email));
    }

    @Override
    public Users save(Users user) {
        return usersRepo.save(user);
    }

    @Override
    public UserDTO create(RegistrationParameters registrationParameters) {
        Users checkUser =  usersRepo.findByEmail(registrationParameters.getEmail()).orElse(null);
        if (checkUser == null){
            Roles role = rolesRepo.findByRole("ROLE_USER");
            if(role != null){
                Users user = mapParamsToEntity(registrationParameters);
                Set<Roles> roles = new HashSet<>();
                roles.add(role);
                user.setRoles(roles);
                user.setPassword(encoder.encode(user.getPassword()));
                return mapEntityToDTO(usersRepo.save(user));
            }
        }else {
            throw new BookberryException("User already exists with username: " + registrationParameters.getEmail());
        }
        return null;
    }

    @Override
    public boolean signIn(LoginRequestDTO loginRequestDTO) {
        Users user = usersRepo.findByEmail(loginRequestDTO.getLogin()).orElse(null);
        if (user != null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails,
                            loginRequestDTO.getPassword(),
                            userDetails.getAuthorities());
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if (usernamePasswordAuthenticationToken.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                return true;
            }
        }
        return false;
    }

    @Override
    public Users getCurrentUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserByEmail(principal.getUsername());
    }

    private Users mapParamsToEntity(RegistrationParameters registrationParameters){
        return modelMapper.map(registrationParameters, Users.class);
    }

    private UserDTO mapEntityToDTO(Users users){
        return modelMapper.map(users, UserDTO.class);
    }
}
