package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.RegistrationRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;

public interface UserFacade {
    UserResponseDto registerUser(RegistrationRequestDto registrationRequestDto);
}
