package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.User;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {
    User registerUser(User user);

    void loginUser(User user, HttpServletRequest request);
}
