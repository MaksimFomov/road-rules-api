package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.model.Answer;
import com.fomov.road_rules_api.repository.AnswerRepository;
import com.fomov.road_rules_api.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(long id) {
        return answerRepository.findById(id)
                .orElseThrow();
    }
}
