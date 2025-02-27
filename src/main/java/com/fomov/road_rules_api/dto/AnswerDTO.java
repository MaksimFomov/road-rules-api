package com.fomov.road_rules_api.dto;

import lombok.Value;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Answer}
 */
@Value
public class AnswerDTO {
    Long id;
    String text;
}