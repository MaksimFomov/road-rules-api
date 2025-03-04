package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.TopicRequestDto;
import com.fomov.road_rules_api.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TopicRequestMapper {
    Topic toEntity(TopicRequestDto topicRequestDto);

    TopicRequestDto toTopicRequestDto(Topic topic);
}