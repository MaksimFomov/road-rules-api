package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.LoginRegistrationRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface UserFacade {
    UserResponseDto registerUser(LoginRegistrationRequestDto registrationRequestDto);

    void loginUser(LoginRegistrationRequestDto loginRegistrationRequestDto, HttpServletRequest request);
}
