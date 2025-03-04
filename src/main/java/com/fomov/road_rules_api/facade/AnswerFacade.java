package com.fomov.road_rules_api.facade;

import com.fomov.road_rules_api.dto.AnswerRequestDto;
import com.fomov.road_rules_api.dto.AnswerResponseDto;

import java.util.List;

public interface AnswerFacade {
    List<AnswerResponseDto> getAllAnswers();

    AnswerResponseDto getAnswerById(long id);

    AnswerResponseDto addAnswer(AnswerRequestDto answerRequestDto);

    AnswerResponseDto changeAnswerById(long id, AnswerRequestDto changedAnswerRequestDto);

    void deleteAnswerById(long id);
}
