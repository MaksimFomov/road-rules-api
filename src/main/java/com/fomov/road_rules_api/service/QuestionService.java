package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    Question getQuestionById(long id);

    List<Question> getQuestionsByTopicId(long topicId);

    Question addQuestion(Question question);

    Question changeQuestionById(long id, Question changedQuestion);

    void deleteQuestionById(long id);
}
