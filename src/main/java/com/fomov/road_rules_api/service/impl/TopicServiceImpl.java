package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.model.Topic;
import com.fomov.road_rules_api.repository.TopicRepository;
import com.fomov.road_rules_api.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
}
