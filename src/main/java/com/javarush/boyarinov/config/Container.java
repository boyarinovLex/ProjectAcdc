package com.javarush.boyarinov.config;

import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.repository.AnswersRepository;
import com.javarush.boyarinov.repository.QuestRepository;
import com.javarush.boyarinov.repository.Repository;
import com.javarush.boyarinov.service.AnswerService;
import com.javarush.boyarinov.service.GameService;
import com.javarush.boyarinov.service.QuestService;

public class Container {

    public static final UploadQuests uploadQuests = new UploadQuests();
    public static final Repository<Quest> questRepository = new QuestRepository();
    public static final AnswersRepository answersRepository = new AnswersRepository();
    public static final GameService gameService = new GameService();
    public static final QuestService questService = new QuestService();
    public static final AnswerService answerService = new AnswerService();
}
