package com.fomov.road_rules_api.facade.impl;

import com.fomov.road_rules_api.dto.AnswerRequestDto;
import com.fomov.road_rules_api.dto.AnswerResponseDto;
import com.fomov.road_rules_api.facade.AnswerFacade;
import com.fomov.road_rules_api.mapper.AnswerMapper;
import com.fomov.road_rules_api.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerFacadeImpl implements AnswerFacade {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerFacadeImpl(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @Override
    public List<AnswerResponseDto> getAllAnswers() {
        return (List<AnswerResponseDto>) answerMapper.toAnswerDtos(
                answerService.getAllAnswers()
        );
    }

    @Override
    public AnswerResponseDto getAnswerById(long id) {
        return answerMapper.toAnswerDto(
                answerService.getAnswerById(id)
        );
    }

    @Override
    public AnswerResponseDto addAnswer(AnswerRequestDto answerRequestDto) {
        return answerMapper.toAnswerDto(
                answerService.addAnswer(
                        answerMapper.toEntity(answerRequestDto))
                );
    }

    @Override
    public AnswerResponseDto changeAnswerById(long id, AnswerRequestDto changedAnswerRequestDto) {
        return answerMapper.toAnswerDto(
                answerService.changeAnswerById(
                        id, (answerMapper.toEntity(changedAnswerRequestDto))
                ));
    }

    @Override
    public void deleteAnswerById(long id) {
        answerService.deleteAnswerById(id);
    }
}
