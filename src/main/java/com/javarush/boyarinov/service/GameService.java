package com.javarush.boyarinov.service;

import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameService {

    private final AnswerService answerService;

    public String getQuestion(Quest quest, long questionId) {
        return quest.getQuestionsList().get((int) questionId);
    }

    public long nextQuestion(boolean answerValue, long questId, long questionId) {
        Answers answer = answerService.getAnswer(questId, questionId);
        String winningMassage = answer.getWinningMessage();
        if (answerValue && winningMassage.isBlank()) {
            return ++questionId;
        } else {
            return answerValue
                    ? questionId
                    : -1L;
        }
    }

    public String checkMessage(boolean value, long questId, long questionId) {
        Answers answer = answerService.getAnswer(questId, questionId);
        String winningMessage = answer.getWinningMessage();
        String lossMessage = answer.getLossMessage();

        return value
                ? winningMessage
                : lossMessage;
    }
}
