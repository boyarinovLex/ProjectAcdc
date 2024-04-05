package com.javarush.boyarinov.service;

import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class GameServiceTest {

    private final AnswerService answerService = Mockito.mock(AnswerService.class);

    private final GameService gameService = new GameService(answerService);

    private Quest quest;

    @BeforeEach
    void setUp() {
        quest = Quest.builder()
                .name("Quest 1")
                .id(1L)
                .questionsList(List.of("Question 1", "Question 2", "Question 3"))
                .build();
    }

    @Test
    void getQuestionTest() {
        //given
        long questionId = 1;
        //when
        String actualQuestion = gameService.getQuestion(quest, questionId);
        //then
        String expectedQuestion = quest.getQuestionsList().get((int) questionId);
        Assertions.assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void whenHaveNextQuestion_thenReturnNextQuestion() {
        //given
        boolean answerValue = true;
        long questId = quest.getId();
        long questionId = 0;
        Answers answers = Answers.builder()
                .questId(questId)
                .questionId(questionId)
                .winningMessage("")
                .build();
        //when
        Mockito.when(answerService.getAnswer(questId, questionId)).thenReturn(answers);
        long nextQuestion = gameService.nextQuestion(answerValue, questId, questionId);
        //then
        long expectedQuestionId = 1;
        Assertions.assertEquals(expectedQuestionId, nextQuestion);

    }

    @Test
    void whenHaveWinningMessage_thenReturnCurrentQuestionId() {
        //given
        boolean answerValue = true;
        long questId = quest.getId();
        long questionId = 0;
        Answers answers = Answers.builder()
                .questId(questId)
                .questionId(questionId)
                .winningMessage("You win!")
                .build();
        //when
        Mockito.when(answerService.getAnswer(questId, questionId)).thenReturn(answers);
        long nextQuestion = gameService.nextQuestion(answerValue, questId, questionId);
        //then
        Assertions.assertEquals(questionId, nextQuestion);
    }

    @Test
    void whenAnswerIsWrong_thenReturnIncorrectQuestionId() {
        //given
        boolean answerValue = false;
        long questId = quest.getId();
        long questionId = 0;
        Answers answers = Answers.builder()
                .questId(questId)
                .questionId(questionId)
                .winningMessage("")
                .build();
        //when
        Mockito.when(answerService.getAnswer(questId, questionId)).thenReturn(answers);
        long nextQuestion = gameService.nextQuestion(answerValue, questId, questionId);
        //then
        long expectedQuestionId = -1;
        Assertions.assertEquals(expectedQuestionId, nextQuestion);
    }

    @Test
    void whenTrue_thenReturnWinningMessage() {
        //given
        boolean answerValue = true;
        long questId = quest.getId();
        long questionId = 0;
        Answers answers = Answers.builder()
                .questId(questId)
                .questionId(questionId)
                .winningMessage("You win!")
                .build();
        //when
        Mockito.when(answerService.getAnswer(questId, questionId)).thenReturn(answers);
        String message = gameService.checkMessage(answerValue, questId, questionId);
        //then
        String winningMessage = answers.getWinningMessage();
        Assertions.assertEquals(winningMessage, message);
    }

    @Test
    void whenFalse_thenReturnLossMessage() {
        //given
        boolean answerValue = false;
        long questId = quest.getId();
        long questionId = 0;
        Answers answers = Answers.builder()
                .questId(questId)
                .questionId(questionId)
                .winningMessage("")
                .lossMessage("You lose!")
                .build();
        //when
        Mockito.when(answerService.getAnswer(questId, questionId)).thenReturn(answers);
        String message = gameService.checkMessage(answerValue, questId, questionId);
        //then
        String lossMessage = answers.getLossMessage();
        Assertions.assertEquals(lossMessage, message);
    }
}