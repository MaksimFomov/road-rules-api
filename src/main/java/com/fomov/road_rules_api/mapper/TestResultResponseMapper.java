package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.TestResultResponseDto;
import com.fomov.road_rules_api.model.TestResult;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestResultResponseMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "topicTotalQuestions", target = "topic.totalQuestions")
    @Mapping(source = "topicName", target = "topic.name")
    TestResult toEntity(TestResultResponseDto testResultResponseDto);

    @InheritInverseConfiguration(name = "toEntity")
    TestResultResponseDto toTestResultResponseDto(TestResult testResult);
}