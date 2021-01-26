package com.project.jobsearch.api.dto;


import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

public class LoginDTO {

    @NotNull
    private String username;

    @NotNull
    @Length(min = 8, message = "Le password doit être de 8 caractère")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
