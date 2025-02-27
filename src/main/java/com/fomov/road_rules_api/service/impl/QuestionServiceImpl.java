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

    @Override
    public Question getQuestionById(long id) {
        return questionRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Question> getQuestionsByTopicId(long topicId) {
        return questionRepository.findAllByTopic_Id(topicId);
    }

    @Override
    public Question changeQuestionById(long id, Question updatedQuestion) {
        Question existQuestion = getQuestionById(id);
        existQuestion.setText(updatedQuestion.getText());
        existQuestion.setType(updatedQuestion.getType());
        existQuestion.setTopic(updatedQuestion.getTopic());
        return questionRepository.save(existQuestion);
    }

    @Override
    public void deleteQuestionById(long id) {
        questionRepository.delete(getQuestionById(id));
    }
}
