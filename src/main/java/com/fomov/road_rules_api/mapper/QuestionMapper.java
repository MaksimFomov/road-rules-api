package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.QuestionDTO;
import com.fomov.road_rules_api.model.Question;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AnswerMapper.class})
public interface QuestionMapper {
    Question toEntity(QuestionDTO questionDTO);

    @AfterMapping
    default void linkAnswers(@MappingTarget Question question) {
        question.getAnswers().forEach(answer -> answer.setQuestion(question));
    }

    QuestionDTO toQuestionDTO(Question question);
}