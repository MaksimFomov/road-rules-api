package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.TopicResponseDto;
import com.fomov.road_rules_api.model.Topic;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TopicResponseMapper {
    Topic toEntity(TopicResponseDto topicResponseDto);

    @AfterMapping
    default void linkQuestions(@MappingTarget Topic topic) {
        topic.getQuestions().forEach(question -> question.setTopic(topic));
    }

    @AfterMapping
    default void linkTestResults(@MappingTarget Topic topic) {
        topic.getTestResults().forEach(testResult -> testResult.setTopic(topic));
    }

    TopicResponseDto toTopicResponseDto(Topic topic);
}