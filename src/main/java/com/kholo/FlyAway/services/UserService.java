package com.kholo.FlyAway.services;
import com.kholo.FlyAway.models.User;
import com.kholo.FlyAway.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Get user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Add a new user
    public User addUser(User user) {
        // Check if a user with the same email already exists
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            // Handle the case where a user with the same email already exists
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        }

        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long userId, User updatedUser) {
        // Check if the user with the given ID exists
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            // Update the existing user with the new information
            updatedUser.setUserId(userId);
            return userRepository.save(updatedUser);
        } else {
            // Handle the case where the user with the given ID is not found
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }
    }

    // Delete a user by ID
    public void deleteUser(Long userId) {
        // Check if the user with the given ID exists
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            // Delete the existing user
            userRepository.deleteById(userId);
        } else {
            // Handle the case where the user with the given ID is not found
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }
    }
}
