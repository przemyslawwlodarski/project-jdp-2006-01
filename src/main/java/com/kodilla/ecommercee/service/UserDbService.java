package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDbService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }
}
