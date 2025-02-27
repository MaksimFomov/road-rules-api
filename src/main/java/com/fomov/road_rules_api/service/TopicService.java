package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopics();

    Topic getTopicById(long id);

    Topic changeTopicById(long id, Topic updatedTopic);

    void deleteTopicById(long id);
}
