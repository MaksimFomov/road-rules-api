package com.fomov.road_rules_api.dto;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Topic}
 */
public record TopicRequestDto(String name, int totalQuestions) {
}