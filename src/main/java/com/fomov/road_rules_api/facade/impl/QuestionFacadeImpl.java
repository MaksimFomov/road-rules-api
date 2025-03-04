package com.fomov.road_rules_api.facade.impl;

import com.fomov.road_rules_api.dto.QuestionRequestDto;
import com.fomov.road_rules_api.dto.QuestionResponseDto;
import com.fomov.road_rules_api.facade.QuestionFacade;
import com.fomov.road_rules_api.mapper.QuestionMapper;
import com.fomov.road_rules_api.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionFacadeImpl implements QuestionFacade {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionFacadeImpl(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @Override
    public List<QuestionResponseDto> getAllQuestions() {
        return (List<QuestionResponseDto>) questionMapper.toQuestionResponseDtos(
                questionService.getAllQuestions()
        );
    }

    @Override
    public QuestionResponseDto getQuestionById(long id) {
        return questionMapper.toQuestionResponseDto(
                questionService.getQuestionById(id)
        );
    }

    @Override
    public List<QuestionResponseDto> getQuestionsByTopicId(long topicId) {
        return (List<QuestionResponseDto>) questionMapper.toQuestionResponseDtos(
                questionService.getQuestionsByTopicId(topicId)
        );
    }

    @Override
    public QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto) {
        return questionMapper.toQuestionResponseDto(
                questionService.addQuestion(
                        questionMapper.toEntity(questionRequestDto)
                )
        );
    }

    @Override
    public QuestionResponseDto changeQuestionById(long id, QuestionRequestDto changedQuestionRequestDto) {
        return questionMapper.toQuestionResponseDto(
                questionService.changeQuestionById(
                        id, questionMapper.toEntity(changedQuestionRequestDto)
                )
        );
    }

    @Override
    public void deleteQuestionById(long id) {
        questionService.deleteQuestionById(id);
    }
}
