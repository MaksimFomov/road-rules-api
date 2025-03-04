package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.QuestionResponseDto;
import com.fomov.road_rules_api.model.Question;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionResponseMapper {
    @Mapping(source = "topicName", target = "topic.name")
    Question toEntity(QuestionResponseDto questionResponseDto);

    @AfterMapping
    default void linkAnswers(@MappingTarget Question question) {
        question.getAnswers().forEach(answer -> answer.setQuestion(question));
    }

    @Mapping(source = "topic.name", target = "topicName")
    QuestionResponseDto toQuestionResponseDto(Question question);
}