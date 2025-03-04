package com.fomov.road_rules_api.dto;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Answer}
 */
public record AnswerRequestDto(String text, boolean isCorrect, Long questionId) {
}