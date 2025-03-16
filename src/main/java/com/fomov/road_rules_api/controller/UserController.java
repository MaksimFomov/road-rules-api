package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.TestResultRequestDto;
import com.fomov.road_rules_api.dto.TestResultResponseDto;
import com.fomov.road_rules_api.dto.TopicResponseDto;
import com.fomov.road_rules_api.facade.TestResultFacade;
import com.fomov.road_rules_api.facade.TopicFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final TopicFacade topicFacade;
    private final TestResultFacade testResultFacade;

    public UserController(TopicFacade topicFacade, TestResultFacade testResultFacade) {
        this.topicFacade = topicFacade;
        this.testResultFacade = testResultFacade;
    }

    @GetMapping("/get-all-topics")
    public ResponseEntity<List<TopicResponseDto>> getAllTopics() {
        List<TopicResponseDto> topics = topicFacade.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @PostMapping("/process-test-result")
    public ResponseEntity<TestResultResponseDto> processTestResults(@RequestBody TestResultRequestDto testResultRequestDto) {
        TestResultResponseDto testResultResponseDto = testResultFacade.processTestResults(testResultRequestDto);
        return ResponseEntity.ok().body(testResultResponseDto);
    }
}
