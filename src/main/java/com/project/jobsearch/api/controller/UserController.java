package com.project.jobsearch.api.controller;

import com.project.jobsearch.api.dto.UserDTO;
import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/users")
//    public List<UserDTO> getAll() {
//        ModelMapper modelMapper = new ModelMapper();
//        List<UserDTO> usersDTO = new ArrayList<>();
//        List<User> users =  userService.getAll();
//
//        for (User user: users ) {
//            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//            usersDTO.add(userDTO);
//        }
//        return usersDTO;
//    }

    @GetMapping("/user/{id}")
    public UserDTO getById(@PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<User> user =  userService.getById(id);
        User u = user.get();
        UserDTO userDTO =  mapper.map(u, UserDTO.class);
        return userDTO;
    }

//    @PostMapping("/users")
//    public UserDTO create(@RequestBody User user) {
//        ModelMapper mapper = new ModelMapper();
//        UserDTO userDTO = mapper.map(userService.create(user), UserDTO.class);
//        return userDTO;
//    }

    @PutMapping("/users/{id}")
    public UserDTO update(@RequestBody User user, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(userService.update(user, id), UserDTO.class);
        return userDTO;
    }

//    @DeleteMapping("users/{id}")
//    public void delete(@PathVariable Long id) {
//        userService.delete(id);
//    }

}
