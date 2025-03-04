package com.fomov.road_rules_api.dto;

import java.util.Set;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Topic}
 */
public record TopicResponseDto(Long id, String name, int totalQuestions, Set<QuestionResponseDto> questions, Set<TestResultResponseDto> testResults) {
}