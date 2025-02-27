package com.example.waa_lab_project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.waa_lab_project.model.User;
import com.example.waa_lab_project.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsersWithMoreThanOnePost() {
        return userRepository.findUsersWithMoreThanOnePost();
    }
}