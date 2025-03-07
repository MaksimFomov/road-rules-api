package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.LoginRegistrationRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import com.fomov.road_rules_api.model.User;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TestResultMapper.class})
public interface UserMapper {
    User toEntity(LoginRegistrationRequestDto loginRegistrationRequestDto);

    @AfterMapping
    default void linkTestResults(@MappingTarget User user) {
        user.getTestResults().forEach(testResult -> testResult.setUser(user));
    }

    UserResponseDto toUserResponseDto(User user);

    Collection<UserResponseDto> toUserResponseDtos(Collection<User> user);
}