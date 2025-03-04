package com.fomov.road_rules_api.repository;

import com.fomov.road_rules_api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByTopic_Id(long id);

}
