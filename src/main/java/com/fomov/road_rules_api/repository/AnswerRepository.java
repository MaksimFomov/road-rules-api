package com.fomov.road_rules_api.repository;

import com.fomov.road_rules_api.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
