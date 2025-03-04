package com.fomov.road_rules_api.dto;

import com.fomov.road_rules_api.enums.QuestionType;

import java.util.Set;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Question}
 */
public record QuestionResponseDto(Long id, String text, QuestionType type, Set<AnswerResponseDto> answers, Long topicName) {
}