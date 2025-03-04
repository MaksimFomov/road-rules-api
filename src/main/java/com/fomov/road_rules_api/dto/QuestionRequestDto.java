package com.fomov.road_rules_api.dto;

import com.fomov.road_rules_api.enums.QuestionType;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Question}
 */
public record QuestionRequestDto(String text, QuestionType type, Long topicId) {
}