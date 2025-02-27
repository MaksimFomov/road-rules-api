package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.AnswerDTO;
import com.fomov.road_rules_api.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {
    Answer toEntity(AnswerDTO answerDTO);

    AnswerDTO toAnswerDTO(Answer answer);
}