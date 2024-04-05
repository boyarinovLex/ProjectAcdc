package com.javarush.boyarinov.service;

import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.repository.AnswersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;


class AnswerServiceTest {

    private final AnswersRepository answersRepository = Mockito.mock(AnswersRepository.class);

    private final AnswerService answerService = new AnswerService(answersRepository);

    private Answers answers;

    @BeforeEach
    void setUp() {
        answers = Answers.builder()
                .questId(1L)
                .questionId(0L)
                .answerMap(Map.of("Answer 1", true, "Answer 2", false))
                .build();
    }

    @Test
    void createTest() {
        //given
        long questId = 1L;
        //when
        answerService.create(questId, answers);
        //then
        Mockito.verify(answersRepository).create(questId, answers);
    }

    @Test
    void getAnswerTest() {
        //given
        long questId = 1L;
        long questionId = 0L;
        //when
        Mockito.when(answersRepository.getAnswers(Mockito.anyLong(), Mockito.anyLong())).thenReturn(answers);
        Answers actualAnswer = answerService.getAnswer(questId, questionId);
        //then
        Assertions.assertEquals(answers, actualAnswer);
        Mockito.verify(answersRepository).getAnswers(questId, questionId);
    }

    @Test
    void getAllTest() {
        //given
        long questId = 1L;
        //when
        Mockito.when(answersRepository.getAll(questId)).thenReturn(List.of(answers));
        List<Answers> answersList = answerService.getAll(questId);
        //then
        Assertions.assertEquals(1, answersList.size());
        Mockito.verify(answersRepository).getAll(questId);
    }

    @Test
    void updateTest() {
        //given
        long questId = 1L;
        long questionId = 0L;
        //when
        answerService.update(questId, questionId, answers);
        //then
        Mockito.verify(answersRepository).update(questId, questionId, answers);
    }

    @Test
    void removeTest() {//given
        long questId = 1L;
        long questionId = 0L;
        //when
        answerService.remove(questId, questionId);
        //then
        Mockito.verify(answersRepository).remove(questId, questionId);
    }
}