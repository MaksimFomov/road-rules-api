package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.Question;
import com.fomov.road_rules_api.model.Topic;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    Question getQuestionById(long id);

    List<Question> getQuestionsByTopicId(long topicId);

    Question changeQuestionById(long id, Question updatedQuestion);

    void deleteQuestionById(long id);
}
