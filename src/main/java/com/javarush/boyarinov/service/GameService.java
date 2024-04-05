package com.javarush.boyarinov.service;

import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameService {

    private final AnswerService answerService;

    public String getQuestion(Quest quest, long questionId) {
        return quest.getQuestionsList().get((int) questionId);
    }

    public String nextQuestion(boolean answerValue, long questId, long questionId) {
        long nextQuestionId = checkAnswer(answerValue, questId, questionId);
        return nextQuestionId > 0
                ? Constant.SEND_PATH_TO_NEXT_QUESTION.formatted(questId, nextQuestionId, answerValue)
                : Constant.SEND_PATH_TO_NEXT_QUESTION.formatted(questId, questionId, answerValue);
    }

    public String checkResultMessage(boolean answerValue, long questId, long questionId) {
        Answers answer = answerService.getAnswer(questId, questionId);
        String winningMessage = answer.getWinningMessage();
        String lossMessage = answer.getLossMessage();

        return answerValue
                ? winningMessage
                : lossMessage;
    }

    private long checkAnswer(boolean answerValue, long questId, long questionId) {
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
}
