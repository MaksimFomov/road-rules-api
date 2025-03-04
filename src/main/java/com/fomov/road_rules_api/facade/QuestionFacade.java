package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.QuestionRequestDto;
import com.fomov.road_rules_api.dto.QuestionResponseDto;

import java.util.List;

public interface QuestionFacade {
    List<QuestionResponseDto> getAllQuestions();

    QuestionResponseDto getQuestionById(long id);

    List<QuestionResponseDto> getQuestionsByTopicId(long topicId);

    QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto);

    QuestionResponseDto changeQuestionById(long id, QuestionRequestDto changedQuestionRequestDto);

    void deleteQuestionById(long id);
}
