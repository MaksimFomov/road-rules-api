package com.fomov.road_rules_api.dto;

/**
 * DTO for {@link com.fomov.road_rules_api.model.TestResultDetail}
 */
public record TestResultDetailResponseDto(Long questionId, Long selectedAnswerId, boolean isCorrect) {
}