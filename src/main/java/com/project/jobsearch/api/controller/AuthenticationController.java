package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.LoginDTO;
import com.project.jobsearch.api.dto.UserDTO;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.service.AuthenticationService;
import com.project.jobsearch.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }


    @PostMapping("/login")
    public boolean checkLogin(@RequestBody @Valid LoginDTO dto) {
        if(authenticationService.authenticationLoginValidation(dto.getUsername(), dto.getPassword())) {
            return true;
        }
        return false;
    }

    @GetMapping("/singin")
    public boolean checkSignin(String email, User user) {
        if(authenticationService.authenticationSigninValidation(email)) {
            create(user);
            return true;
        }
        return false;
    }

    public UserDTO create(@RequestBody User user) {
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(userService.create(user), UserDTO.class);
        return userDTO;
    }
}
