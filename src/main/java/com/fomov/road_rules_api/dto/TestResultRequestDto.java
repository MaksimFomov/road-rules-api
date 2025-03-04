package com.fomov.road_rules_api.dto;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.fomov.road_rules_api.model.TestResult}
 */
public record TestResultRequestDto(Long topicId, LocalDateTime testDate, int score, int timeSpent, Long userId) {
}