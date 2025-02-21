package com.fomov.road_rules_api.repository;

import com.fomov.road_rules_api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
