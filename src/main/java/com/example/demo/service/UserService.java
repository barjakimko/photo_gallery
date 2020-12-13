package com.example.demo.service;

import com.example.demo.entity.ApplicationUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<ApplicationUser> getAllUsers();

    Optional<ApplicationUser> login(ApplicationUser validUser);

    ApplicationUser findUserById(Long id);

    ApplicationUser findUserByLogin(String login);

    void saveUser(ApplicationUser applicationUser);

}
