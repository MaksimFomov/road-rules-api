package com.fomov.road_rules_api.dto;

import java.util.Map;

/**
 * DTO for {@link com.fomov.road_rules_api.model.TestResult}
 */
public record TestResultRequestDto(Long userId, Long topicId, Map<Long, Long> userResponses, int timeSpent) {
}