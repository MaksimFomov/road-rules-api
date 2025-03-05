package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.TopicRequestDto;
import com.fomov.road_rules_api.dto.TopicResponseDto;
import com.fomov.road_rules_api.facade.TopicFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicFacade topicFacade;

    public TopicController(TopicFacade topicFacade) {
        this.topicFacade = topicFacade;
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDto>> getAllTopics() {
        List<TopicResponseDto> topics = topicFacade.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDto> getTopicById(@PathVariable long id) {
        TopicResponseDto topic = topicFacade.getTopicById(id);
        return ResponseEntity.ok(topic);
    }

    @PostMapping
    public ResponseEntity<TopicResponseDto> addTopic(@RequestBody TopicRequestDto topicRequestDto) {
        TopicResponseDto createdTopic = topicFacade.addTopic(topicRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponseDto> changeTopicById(
            @PathVariable long id,
            @RequestBody TopicRequestDto changedTopicRequestDto) {
        TopicResponseDto updatedTopic = topicFacade.changeTopicById(id, changedTopicRequestDto);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopicById(@PathVariable long id) {
        topicFacade.deleteTopicById(id);
        return ResponseEntity.noContent().build();
    }
}
