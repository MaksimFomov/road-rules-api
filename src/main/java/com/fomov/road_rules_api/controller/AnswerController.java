package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.AnswerRequestDto;
import com.fomov.road_rules_api.dto.AnswerResponseDto;
import com.fomov.road_rules_api.facade.AnswerFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerFacade answerFacade;

    public AnswerController(AnswerFacade answerFacade) {
        this.answerFacade = answerFacade;
    }

    @GetMapping
    public ResponseEntity<List<AnswerResponseDto>> getAllAnswers() {
        List<AnswerResponseDto> answers = answerFacade.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDto> getAnswerById(@PathVariable long id) {
        AnswerResponseDto answer = answerFacade.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }

    @PostMapping
    public ResponseEntity<AnswerResponseDto> addAnswer(@RequestBody AnswerRequestDto answerRequestDto) {
        AnswerResponseDto createdAnswer = answerFacade.addAnswer(answerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDto> changeAnswerById(
            @PathVariable long id,
            @RequestBody AnswerRequestDto changedAnswerRequestDto) {
        AnswerResponseDto updatedAnswer = answerFacade.changeAnswerById(id, changedAnswerRequestDto);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswerById(@PathVariable long id) {
        answerFacade.deleteAnswerById(id);
        return ResponseEntity.noContent().build();
    }
}
