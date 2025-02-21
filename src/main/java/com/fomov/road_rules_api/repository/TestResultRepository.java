package com.fomov.road_rules_api.repository;

import com.fomov.road_rules_api.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
