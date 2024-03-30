package com.javarush.boyarinov.service;

import com.javarush.boyarinov.config.Container;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;

public class GameService {

    private final AnswerService answerService = Container.answerService;

    public String getQuestion(Quest quest, int questionId) {
        return quest.getQuestionsList().get(questionId);
    }

    public int nextQuestion(boolean answerValue, long questId, int questionId) {
        Answers answer = answerService.getAnswer(questId, questionId);
        String winningMassage = answer.getWinningMessage();
        if (answerValue && winningMassage.isBlank()) {
            return ++questionId;
        } else {
            return answerValue
                    ? questionId
                    : -1;
        }
    }

    public String checkMessage(boolean value, long questId, int questionId) {
        Answers answer = answerService.getAnswer(questId, questionId);
        String winningMessage = answer.getWinningMessage();
        String lossMessage = answer.getLossMessage();

        return value
                ? winningMessage
                : lossMessage;
    }
}
