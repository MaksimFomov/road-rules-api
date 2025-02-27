package com.fomov.road_rules_api.service;

import com.fomov.road_rules_api.model.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswers();

    Answer getAnswerById(long id);


}
