package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.AnswerRequestDto;
import com.fomov.road_rules_api.dto.AnswerResponseDto;
import com.fomov.road_rules_api.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {
    @Mapping(source = "questionId", target = "question.id")
    Answer toEntity(AnswerRequestDto answerRequestDto);

    @Mapping(source = "question.text", target = "questionText")
    AnswerResponseDto toAnswerDto(Answer answer);

    @Mapping(source = "question.text", target = "questionText")
    Collection<AnswerResponseDto> toAnswerDtos(Collection<Answer> answer);
}