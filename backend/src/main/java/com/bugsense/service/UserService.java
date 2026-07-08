package com.bugsense.service;

import org.springframework.stereotype.Service;

import com.bugsense.dao.UserDAO;
import com.bugsense.model.User;

@Service
public class UserService {

    private final UserDAO userDAO;

    // For Spring Boot
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // For the old console application
    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean register(User user) {
        return userDAO.registerUser(user);
    }

    public User login(String email, String password) {

        User user = userDAO.findByEmail(email);

        if (user == null) {
            return null;
        }

        if (user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}