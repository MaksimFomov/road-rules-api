package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.TestResultResponseDto;

import java.util.List;

public interface TestResultFacade {
    List<TestResultResponseDto> getAllTestResults();

    TestResultResponseDto getTestResultById(long id);
}
