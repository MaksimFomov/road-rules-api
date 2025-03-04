package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.QuestionRequestDto;
import com.fomov.road_rules_api.dto.QuestionResponseDto;
import com.fomov.road_rules_api.model.Question;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {
    @Mapping(source = "topicId", target = "topic.id")
    Question toEntity(QuestionRequestDto questionRequestDto);

    @AfterMapping
    default void linkAnswers(@MappingTarget Question question) {
        question.getAnswers().forEach(answer -> answer.setQuestion(question));
    }

    @Mapping(source = "topic.name", target = "topicName")
    QuestionResponseDto toQuestionResponseDto(Question question);

    @Mapping(source = "topic.name", target = "topicName")
    Collection<QuestionResponseDto> toQuestionResponseDtos(Collection<Question> question);
}