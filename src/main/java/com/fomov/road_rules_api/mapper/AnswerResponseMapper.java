package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.AnswerResponseDto;
import com.fomov.road_rules_api.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerResponseMapper {
    @Mapping(source = "questionText", target = "question.text")
    Answer toEntity(AnswerResponseDto answerResponseDto);

    @Mapping(source = "question.text", target = "questionText")
    AnswerResponseDto toAnswerResponseDto(Answer answer);
}