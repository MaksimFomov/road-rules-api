package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.exception.TopicNotFoundException;
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

    @Override
    public Topic getTopicById(long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Topic not found with ID: " + id));
    }

    @Override
    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic changeTopicById(long id, Topic changedTopic) {
        Topic existTopic = getTopicById(id);
        existTopic.setName(changedTopic.getName());
        existTopic.setTotalQuestions(changedTopic.getTotalQuestions());
        return topicRepository.save(existTopic);
    }

    @Override
    public void deleteTopicById(long id) {
        topicRepository.delete(getTopicById(id));
    }
}
