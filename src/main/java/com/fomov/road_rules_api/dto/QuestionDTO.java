package com.fomov.road_rules_api.dto;

import com.fomov.road_rules_api.enums.QuestionType;
import lombok.Value;

import java.util.Set;

/**
 * DTO for {@link com.fomov.road_rules_api.model.Question}
 */
@Value
public class QuestionDTO {
    Long id;
    String text;
    QuestionType type;
    Set<AnswerDTO> answers;
}