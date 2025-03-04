package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.UserResponseDto;
import com.fomov.road_rules_api.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TestResultResponseMapper.class})
public interface UserResponseMapper {
    User toEntity(UserResponseDto userResponseDto);

    @AfterMapping
    default void linkTestResults(@MappingTarget User user) {
        user.getTestResults().forEach(testResult -> testResult.setUser(user));
    }

    UserResponseDto toUserResponseDto(User user);
}