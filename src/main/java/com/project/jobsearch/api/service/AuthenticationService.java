package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private UserService userService;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    public boolean authenticationLoginValidation(String email, String password) {
        Optional<User> user = userService.getByEmail(email);

        if (user.isEmpty() || !(BCrypt.checkpw(password, user.get().getPassword()))) {
            return false;
        }
        return true;
    }

    public boolean authenticationSigninValidation(String email) {
        Optional<User> user = userService.getByEmail(email);

        if (user.isEmpty()) {
            return true;
        }
        return false;
    }
}
