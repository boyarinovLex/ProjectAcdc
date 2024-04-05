package com.javarush.boyarinov.repository;

import com.javarush.boyarinov.exception.AppException;
import com.javarush.boyarinov.model.Answers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


class AnswersRepositoryTest {

    private final AnswersRepository answersRepository = new AnswersRepository();

    private Answers answers;

    @BeforeEach
    void createAnswers() {
        answers = Answers.builder()
                .questId(1)
                .questionId(0)
                .answerMap(Map.of("Answer 1", true, "Answer 2", false))
                .build();
        answersRepository.create(answers.getQuestId(), answers);
    }

    @Test
    void whenCorrectData_thenGetAnswer() {
        long questId = 1;
        long questionId = 0;
        Answers actualAnswers = answersRepository.getAnswers(questId, questionId);
        Assertions.assertEquals(answers, actualAnswers);
    }

    @Test
    void whenQuestDataIsIncorrect_throwAppException() {
        long questId = 3;
        long questionId = 0;

        Assertions.assertThrows(AppException.class,
                () -> answersRepository.getAnswers(questId, questionId));
    }

    @Test
    void whenQuestDataIsIncorrect_throwAppExceptionWithMessage() {
        long questId = 2;
        long questionId = 0;
        String expectedMessage = "Quest with ID %d does not exist".formatted(questId);
        String actualMessage = "";

        try {
            answersRepository.getAnswers(questId, questionId);
        } catch (AppException e) {
            actualMessage = e.getMessage();
        }

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void whenQuestionDataIsIncorrect_throwAppException() {
        long questId = 1;
        long questionId = 7;

        Assertions.assertThrows(AppException.class,
                () -> answersRepository.getAnswers(questId, questionId));
    }

    @Test
    void whenQuestionDataIsIncorrect_throwAppExceptionWithMessage() {
        long questId = 1;
        long questionId = 4;
        String expectedMessage = "No answer or wrong data";
        String actualMessage = "";

        try {
            answersRepository.getAnswers(questId, questionId);
        } catch (AppException e) {
            actualMessage = e.getMessage();
        }

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void getAllTest() {
        //given
        long questId = 1;
        //when
        List<Answers> actualAnswersList = answersRepository.getAll(questId);
        //then
        List<Answers> expectedAnswersList = List.of(answers);
        Assertions.assertEquals(expectedAnswersList, actualAnswersList);

    }

    @Test
    void updateTest() {
        //given
        long questId = 1;
        long questionId = 0;
        //when
        Answers expectedAnswers = Answers.builder()
                .questId(questId)
                .questionId(questionId)
                .answerMap(Map.of("Answer 3", false, "Answer 4", true))
                .build();
        //then
        answersRepository.update(questId, questionId, expectedAnswers);
        Answers actualAnswers = answersRepository.getAnswers(questId, questionId);
        Assertions.assertEquals(expectedAnswers, actualAnswers);

    }
}