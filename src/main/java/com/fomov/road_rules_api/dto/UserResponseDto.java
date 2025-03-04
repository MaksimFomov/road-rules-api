package com.fomov.road_rules_api.dto;

import com.fomov.road_rules_api.enums.Role;

import java.util.Set;

/**
 * DTO for {@link com.fomov.road_rules_api.model.User}
 */
public record UserResponseDto(Long id, String username, String password, Set<Role> roles,
                              Set<TestResultResponseDto> testResults) {
}