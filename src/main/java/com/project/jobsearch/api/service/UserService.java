package com.project.jobsearch.api.service;

import com.project.jobsearch.api.entity.User;
import com.project.jobsearch.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * @author johnd
 * @version 1.0
 */
@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user
     * @param user
     * @return The created user
     */
    public User create(User user) {
        int strength = 10;
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(strength, new SecureRandom());
        String password = bcrypt.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

//    /**
//     * Get all the users
//     * @return List of users
//     */
//    public List<User> getAll() {
//        List<User> users =  userRepository.findAll();
//        return users;
//    }

    /**
     * Get an user by id
     * @param id
     * @return An user
     */
    public Optional<User> getById(final Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return null;

        return user;
    }

    /**
     * Replace rows of an user
     * @param newUser
     * @param id
     * @return The updated user
     */
    public User update(User newUser, final Long id) {
        /*int strength = 10;
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(strength, new SecureRandom());
        String password = bcrypt.encode(user.getPassword());
        user.setPassword(password);*/
        return userRepository.findById(id)
                .map(user -> {
                    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10, new SecureRandom());
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setPassword(bcrypt.encode(newUser.getPassword()));
                    user.setEmail(newUser.getEmail());
                    user.setPhone(newUser.getPhone());
                    user.setAddress(newUser.getAddress());
                    user.setCp(newUser.getCp());
                    user.setCity(newUser.getCity());
                    user.setAvatar(newUser.getAvatar());
                    userRepository.save(user);
                    return user;
                })
                .orElseGet(() -> {
                    newUser.setUserId(id);
                    userRepository.save(newUser);
                    return newUser;
                });
    }

//    /**
//     * Delete an user
//     * @param id
//     */
//    public void delete(final Long id) {
//        userRepository.deleteById(id);
//    }

    public Optional<User> getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user;
    }



}
