package com.example.demo.service;

import com.example.demo.entity.ApplicationUser;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    ApplicationUserRepository userRepository;

    @Autowired
    public UserServiceImpl(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<ApplicationUser> getAllUsers() {
        return (List<ApplicationUser>) userRepository.findAll();
    }

    @Override
    public Optional<ApplicationUser> login(ApplicationUser validUser) {
        return getAllUsers().stream()
                .filter(ApplicationUser -> ApplicationUser.getLogin().equals(validUser.getLogin())
                        && ApplicationUser.getPassword().equals(validUser.getPassword()))
                .findAny();
    }

    @Override
    public ApplicationUser findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id,
                ApplicationUser.class.getSimpleName()));
    }

    @Override
    public ApplicationUser findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    public void saveUser(ApplicationUser applicationUser) {
        userRepository.save(applicationUser);
    }
}
