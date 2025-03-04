package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.TopicRequestDto;
import com.fomov.road_rules_api.dto.TopicResponseDto;

import java.util.List;

public interface TopicFacade {
    List<TopicResponseDto> getAllTopics();

    TopicResponseDto getTopicById(long id);

    TopicResponseDto addTopic(TopicRequestDto topicRequestDto);

    TopicResponseDto changeTopicById(long id, TopicRequestDto changedTopicRequestDto);

    void deleteTopicById(long id);
}
