package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.TestResultRequestDto;
import com.fomov.road_rules_api.model.TestResult;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestResultRequestMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "topicId", target = "topic.id")
    TestResult toEntity(TestResultRequestDto testResultRequestDto);

    @InheritInverseConfiguration(name = "toEntity")
    TestResultRequestDto toTestResultRequestDto(TestResult testResult);
}