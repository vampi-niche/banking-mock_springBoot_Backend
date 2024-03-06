package com.example.banking.service;

import com.example.banking.model.User;

public interface AuthService {
    String login(String username, String password);
    void logout(String token);
    User register(User user);
    // other methods
}
