package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.TestResult;

import java.util.List;
import java.util.Map;

public interface TestResultService {
    List<TestResult> getAllTestResults();

    TestResult getTestResultById(long id);

    TestResult processTestResults(TestResult testResult, Map<Long, Long> userResponses);
}
