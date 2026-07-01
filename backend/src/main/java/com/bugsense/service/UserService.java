package com.bugsense.service;

import com.bugsense.dao.UserDAO;
import com.bugsense.model.User;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

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