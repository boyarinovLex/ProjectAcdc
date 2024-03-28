package com.javarush.boyarinov.service;

import com.javarush.boyarinov.model.Quest;

public class GameService {

    public String getQuestion(Quest quest, int questionId) {
        return quest.getQuestionsList().get(questionId);
    }

    public int nextQuestion(boolean answerValue, int questionId) {
        if (answerValue) {
            return ++questionId;
        } else {
            return -1;
        }
    }
}
