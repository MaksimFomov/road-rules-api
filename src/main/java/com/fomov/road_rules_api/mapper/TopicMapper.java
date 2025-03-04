package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.TopicRequestDto;
import com.fomov.road_rules_api.dto.TopicResponseDto;
import com.fomov.road_rules_api.model.Topic;
import org.mapstruct.*;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TopicMapper {
    Topic toEntity(TopicRequestDto topicRequestDto);

    @AfterMapping
    default void linkQuestions(@MappingTarget Topic topic) {
        topic.getQuestions().forEach(question -> question.setTopic(topic));
    }

    @AfterMapping
    default void linkTestResults(@MappingTarget Topic topic) {
        topic.getTestResults().forEach(testResult -> testResult.setTopic(topic));
    }

    TopicResponseDto toTopicResponseDto(Topic topic);

    Collection<TopicResponseDto> toTopicResponseDtos(Collection<Topic> topic);
}