package com.fomov.road_rules_api.facade.impl;

import com.fomov.road_rules_api.dto.TopicRequestDto;
import com.fomov.road_rules_api.dto.TopicResponseDto;
import com.fomov.road_rules_api.facade.TopicFacade;
import com.fomov.road_rules_api.mapper.TopicMapper;
import com.fomov.road_rules_api.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicFacadeImpl implements TopicFacade {
    private final TopicService topicService;
    private final TopicMapper topicMapper;

    public TopicFacadeImpl(TopicService topicService, TopicMapper topicMapper) {
        this.topicService = topicService;
        this.topicMapper = topicMapper;
    }

    @Override
    public List<TopicResponseDto> getAllTopics() {
        return (List<TopicResponseDto>) topicMapper.toTopicResponseDtos(
                topicService.getAllTopics()
        );
    }

    @Override
    public TopicResponseDto getTopicById(long id) {
        return topicMapper.toTopicResponseDto(
                topicService.getTopicById(id)
        );
    }

    @Override
    public TopicResponseDto addTopic(TopicRequestDto topicRequestDto) {
        return topicMapper.toTopicResponseDto(
                topicService.addTopic(
                        topicMapper.toEntity(topicRequestDto)
                )
        );
    }

    @Override
    public TopicResponseDto changeTopicById(long id, TopicRequestDto changedTopicRequestDto) {
        return topicMapper.toTopicResponseDto(
                topicService.changeTopicById(
                        id, topicMapper.toEntity(changedTopicRequestDto)
                )
        );
    }

    @Override
    public void deleteTopicById(long id) {
        topicService.deleteTopicById(id);
    }
}
