package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.TestResult;

import java.util.List;

public interface TestResultService {
    List<TestResult> getAllTestResults();

    TestResult getTestResultById(long id);
}
