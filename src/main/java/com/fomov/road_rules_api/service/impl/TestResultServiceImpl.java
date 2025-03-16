package com.fomov.road_rules_api.service.impl;

import com.fomov.road_rules_api.exception.TestResultNotFoundException;
import com.fomov.road_rules_api.model.Answer;
import com.fomov.road_rules_api.model.Question;
import com.fomov.road_rules_api.model.TestResult;
import com.fomov.road_rules_api.model.TestResultDetail;
import com.fomov.road_rules_api.repository.AnswerRepository;
import com.fomov.road_rules_api.repository.QuestionRepository;
import com.fomov.road_rules_api.repository.TestResultRepository;
import com.fomov.road_rules_api.service.TestResultService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TestResultServiceImpl implements TestResultService {
    private final TestResultRepository testResultRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public TestResultServiceImpl(TestResultRepository testResultRepository, AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.testResultRepository = testResultRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<TestResult> getAllTestResults() {
        return testResultRepository.findAll();
    }

    @Override
    public TestResult getTestResultById(long id) {
        return testResultRepository.findById(id)
                .orElseThrow(() -> new TestResultNotFoundException("Test result not found with ID: " + id));
    }

    public TestResult processTestResults(TestResult testResult, Map<Long, Long> userResponses) {
        int score = 0;

        testResult.setTestDate(LocalDateTime.now());

        List<TestResultDetail> details = new ArrayList<>();

        for (Map.Entry<Long, Long> entry : userResponses.entrySet()) {
            Long questionId = entry.getKey();
            Long answerId = entry.getValue();

            Answer selectedAnswer = answerRepository.findById(answerId).orElse(null);
            Question question = questionRepository.findById(questionId).orElse(null);

            if (question == null || selectedAnswer == null) {
                continue;
            }

            boolean isCorrect = selectedAnswer.isCorrect();
            if (isCorrect) {
                score++;
            }

            TestResultDetail detail = new TestResultDetail();
            detail.setTestResult(testResult);
            detail.setQuestion(question);
            detail.setSelectedAnswer(selectedAnswer);
            detail.setCorrect(isCorrect);
            details.add(detail);
        }

        testResult.setScore(score);
        testResult.setDetails(details);

        return testResultRepository.save(testResult);
    }
}
