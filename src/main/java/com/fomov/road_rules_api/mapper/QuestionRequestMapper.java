package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.QuestionRequestDto;
import com.fomov.road_rules_api.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionRequestMapper {
    @Mapping(source = "topicId", target = "topic.id")
    Question toEntity(QuestionRequestDto questionRequestDto);

    @Mapping(source = "topic.id", target = "topicId")
    QuestionRequestDto toQuestionRequestDto(Question question);
}