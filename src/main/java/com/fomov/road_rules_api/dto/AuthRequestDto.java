package com.fomov.road_rules_api.dto;

/**
 * DTO for {@link com.fomov.road_rules_api.model.User}
 */
public record AuthRequestDto(String username, String password) {
}