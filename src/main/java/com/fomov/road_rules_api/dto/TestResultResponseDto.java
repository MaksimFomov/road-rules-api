package com.fomov.road_rules_api.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.fomov.road_rules_api.model.TestResult}
 */
public record TestResultResponseDto(Long id, String topicName, Integer topicTotalQuestions, LocalDateTime testDate, int score, int timeSpent, Long userId,
                                    List<TestResultDetailResponseDto> details) {
}