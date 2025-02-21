package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.model.Question;
import com.fomov.road_rules_api.repository.QuestionRepository;
import com.fomov.road_rules_api.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
