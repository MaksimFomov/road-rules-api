package com.fomov.road_rules_api.facade.impl;

import com.fomov.road_rules_api.dto.RegistrationRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import com.fomov.road_rules_api.facade.UserFacade;
import com.fomov.road_rules_api.mapper.UserMapper;
import com.fomov.road_rules_api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacadeImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto registerUser(RegistrationRequestDto registrationRequestDto) {
        return userMapper.toUserResponseDto(
                userService.registerUser(
                        userMapper.toEntity(registrationRequestDto)
                )
        );
    }
}
