package com.fomov.road_rules_api.dto;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Answer}
 */
public record AnswerResponseDto(Long id, String text, boolean isCorrect, String questionText) {
}