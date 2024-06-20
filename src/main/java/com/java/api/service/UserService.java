package com.java.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.api.model.User;
import com.java.api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User userPresent = getUserById(id);
        if (userPresent != null) {
            userPresent.setUsername(user.getUsername());
            userPresent.setPassword(user.getPassword());
            userPresent.setRole(user.getRole());
            userPresent.setFirstname(user.getFirstname());
            userPresent.setLastname(user.getLastname());
            userPresent.setEmail(user.getEmail());
            userPresent.setManagedAgencies(user.getManagedAgencies());
            return userRepository.save(userPresent);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
