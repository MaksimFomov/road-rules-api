package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.exception.QuestionNotFoundException;
import com.fomov.road_rules_api.model.Question;
import com.fomov.road_rules_api.repository.QuestionRepository;
import com.fomov.road_rules_api.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with ID: " + id));
    }

    @Override
    public List<Question> getQuestionsByTopicId(long topicId) {
        return questionRepository.findAllByTopic_Id(topicId);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question changeQuestionById(long id, Question changedQuestion) {
        Question existQuestion = getQuestionById(id);
        existQuestion.setText(changedQuestion.getText());
        existQuestion.setType(changedQuestion.getType());
        existQuestion.setTopic(changedQuestion.getTopic());
        return questionRepository.save(existQuestion);
    }

    @Override
    public void deleteQuestionById(long id) {
        questionRepository.delete(getQuestionById(id));
    }
}
