package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.model.TestResult;
import com.fomov.road_rules_api.repository.TestResultRepository;
import com.fomov.road_rules_api.service.TestResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultServiceImpl implements TestResultService {
    private final TestResultRepository testResultRepository;

    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    @Override
    public List<TestResult> getAllTestResults() {
        return testResultRepository.findAll();
    }

    @Override
    public TestResult getTestResultById(long id) {
        return testResultRepository.findById(id)
                .orElseThrow();
    }
}
