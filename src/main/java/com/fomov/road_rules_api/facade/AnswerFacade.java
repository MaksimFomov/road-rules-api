package com.fomov.road_rules_api.facade;

import java.util.List;

public interface AnswerFacade {
    List<AnswerRequestResponseDto> getAllAnswers();

    AnswerRequestResponseDto getAnswerById(long id);

    AnswerRequestResponseDto addAnswer(AnswerRequestResponseDto answerRequestResponseDto);

    AnswerRequestResponseDto changeAnswerById(long id, AnswerRequestResponseDto changedAnswerRequestResponseDto);

    void deleteAnswerById(long id);
}
