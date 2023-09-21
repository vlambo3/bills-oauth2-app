package com.example.msusers.infrastructure.services;

import com.example.msusers.domain.models.User;
import com.example.msusers.domain.repositories.IBillsFeignRepository;
import com.example.msusers.domain.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final IUserRepository userRepository;


    UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findAllBillsPerUser(String userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }
    public List<User> findAll(Boolean enabled) {
        return userRepository.findAll(enabled);
    }
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User updateProperty(String id, String property) {
        return userRepository.updateProperty(id, property);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User deleteUser(String id) {
        return userRepository.deleteUser(id);
    }
}
