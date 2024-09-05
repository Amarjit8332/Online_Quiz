package com.project.service;


import org.mindrot.jbcrypt.BCrypt;

import com.project.dao.UserDAO;
import com.project.model.User;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public boolean login(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }
    

    public void register(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        userDAO.saveUser(user);
    }
}
