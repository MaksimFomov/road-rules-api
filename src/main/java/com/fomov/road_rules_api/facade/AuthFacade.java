package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.AuthRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthFacade {
    UserResponseDto registerUser(AuthRequestDto registrationRequestDto);

    void loginUser(AuthRequestDto authRequestDto, HttpServletRequest request);
}
