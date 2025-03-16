package com.fomov.road_rules_api.facade.impl;

import com.fomov.road_rules_api.dto.TestResultRequestDto;
import com.fomov.road_rules_api.dto.TestResultResponseDto;
import com.fomov.road_rules_api.facade.TestResultFacade;
import com.fomov.road_rules_api.mapper.TestResultMapper;
import com.fomov.road_rules_api.service.TestResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultFacadeImpl implements TestResultFacade {
    private final TestResultService testResultService;
    private final TestResultMapper testResultMapper;

    public TestResultFacadeImpl(TestResultService testResultService, TestResultMapper testResultMapper) {
        this.testResultService = testResultService;
        this.testResultMapper = testResultMapper;
    }

    @Override
    public List<TestResultResponseDto> getAllTestResults() {
        return (List<TestResultResponseDto>) testResultMapper.toTestResultResponseDtos(
                testResultService.getAllTestResults()
        );
    }

    @Override
    public TestResultResponseDto getTestResultById(long id) {
        return testResultMapper.toTestResultResponseDto(
                testResultService.getTestResultById(id)
        );
    }

    @Override
    public TestResultResponseDto processTestResults(TestResultRequestDto testResultRequestDto) {
        return testResultMapper.toTestResultResponseDto(
                testResultService.processTestResults(
                        testResultMapper.toEntity(testResultRequestDto), testResultRequestDto.userResponses()
                )
        );
    }
}
