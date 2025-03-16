package com.fomov.road_rules_api.facade.impl;

import com.fomov.road_rules_api.dto.AuthRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import com.fomov.road_rules_api.facade.AuthFacade;
import com.fomov.road_rules_api.mapper.UserMapper;
import com.fomov.road_rules_api.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthFacadeImpl implements AuthFacade {
    private final AuthService authService;
    private final UserMapper userMapper;

    public AuthFacadeImpl(AuthService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto registerUser(AuthRequestDto authRequestDto) {
        return userMapper.toUserResponseDto(
                authService.registerUser(
                        userMapper.toEntity(authRequestDto)
                )
        );
    }

    @Override
    public void loginUser(AuthRequestDto authRequestDto, HttpServletRequest request) {
        authService.loginUser(userMapper.toEntity(authRequestDto), request);
    }
}
