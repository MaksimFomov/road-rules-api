package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.TestResultResponseDto;
import com.fomov.road_rules_api.facade.TestResultFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/test-results")
public class TestResultController {
    private final TestResultFacade testResultFacade;

    public TestResultController(TestResultFacade testResultFacade) {
        this.testResultFacade = testResultFacade;
    }

    @GetMapping
    public ResponseEntity<List<TestResultResponseDto>> getAllTestResults() {
        List<TestResultResponseDto> results = testResultFacade.getAllTestResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResultResponseDto> getTestResultById(@PathVariable long id) {
        TestResultResponseDto result = testResultFacade.getTestResultById(id);
        return ResponseEntity.ok(result);
    }
}
