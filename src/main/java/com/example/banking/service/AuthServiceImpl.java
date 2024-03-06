package com.example.banking.service;

import com.example.banking.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final Map<String, User> userMap; // Map to store registered users
    private final Map<String, String> loggedInUsers; // Map to store logged-in users and their tokens

    public AuthServiceImpl() {
        this.userMap = new HashMap<>();
        this.loggedInUsers = new HashMap<>();
    }

    @Override
    public String login(String username, String password) {
        for (User user : userMap.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                String token = UUID.randomUUID().toString(); // Generate a unique token
                loggedInUsers.put(token, username);
                return token;
            }
        }
        return null; // Return null if authentication fails
    }

    @Override
    public void logout(String token) {
        loggedInUsers.remove(token); // Remove the user's token upon logout
    }

    @Override
    public User register(User user) {
        if (!userMap.containsKey(user.getUsername())) {
            // Generate a unique user ID (for simplicity, we'll use a UUID)
            String userId = UUID.randomUUID().toString();
            user.setUserId(userId);
            userMap.put(user.getUsername(), user);
            return user;
        }
        return null; // Return null if the username already exists
    }

    // Implement other methods as needed
}
