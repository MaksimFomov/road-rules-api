package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.AnswerRequestDto;
import com.fomov.road_rules_api.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerRequestMapper {
    @Mapping(source = "questionId", target = "question.id")
    Answer toEntity(AnswerRequestDto answerRequestDto);

    @Mapping(source = "question.id", target = "questionId")
    AnswerRequestDto toAnswerRequestDto(Answer answer);
}