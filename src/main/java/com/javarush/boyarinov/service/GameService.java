package com.javarush.boyarinov.service;

import com.javarush.boyarinov.model.Quest;

public class GameService {

    public String getQuestion(Quest quest, int questionId) {
        return quest.getQuestionsList().get(questionId);
    }
}
