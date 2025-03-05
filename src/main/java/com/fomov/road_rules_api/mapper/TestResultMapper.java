package com.fomov.road_rules_api.mapper;

import com.fomov.road_rules_api.dto.TestResultRequestDto;
import com.fomov.road_rules_api.dto.TestResultResponseDto;
import com.fomov.road_rules_api.model.TestResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TestResultMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "topicId", target = "topic.id")
    TestResult toEntity(TestResultRequestDto testResultRequestDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "topic.totalQuestions", target = "topicTotalQuestions")
    @Mapping(source = "topic.name", target = "topicName")
    TestResultResponseDto toTestResultResponseDto(TestResult testResult);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "topic.totalQuestions", target = "topicTotalQuestions")
    @Mapping(source = "topic.name", target = "topicName")
    Collection<TestResultResponseDto> toTestResultResponseDtos(Collection<TestResult> testResult);
}