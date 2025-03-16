package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.QuestionRequestDto;
import com.fomov.road_rules_api.dto.QuestionResponseDto;
import com.fomov.road_rules_api.facade.QuestionFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/questions")
public class QuestionController {
    private final QuestionFacade questionFacade;

    public QuestionController(QuestionFacade questionFacade) {
        this.questionFacade = questionFacade;
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDto>> getAllQuestions() {
        List<QuestionResponseDto> questions = questionFacade.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDto> getQuestionById(@PathVariable long id) {
        QuestionResponseDto question = questionFacade.getQuestionById(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/by-topic/{topicId}")
    public ResponseEntity<List<QuestionResponseDto>> getQuestionsByTopicId(
            @PathVariable long topicId) {
        List<QuestionResponseDto> questions = questionFacade.getQuestionsByTopicId(topicId);
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDto> addQuestion(
            @RequestBody QuestionRequestDto questionRequestDto) {
        QuestionResponseDto createdQuestion = questionFacade.addQuestion(questionRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDto> changeQuestionById(
            @PathVariable long id,
            @RequestBody QuestionRequestDto changedQuestionRequestDto) {
        QuestionResponseDto updatedQuestion =
                questionFacade.changeQuestionById(id, changedQuestionRequestDto);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable long id) {
        questionFacade.deleteQuestionById(id);
        return ResponseEntity.noContent().build();
    }
}
