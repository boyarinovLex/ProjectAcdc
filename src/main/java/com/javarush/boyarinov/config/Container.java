package com.javarush.boyarinov.config;

import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.repository.AnswersRepository;
import com.javarush.boyarinov.repository.QuestRepository;
import com.javarush.boyarinov.repository.Repository;
import com.javarush.boyarinov.service.AnswerService;
import com.javarush.boyarinov.service.GameService;
import com.javarush.boyarinov.service.QuestService;

public class Container {

    public static final QuestsLoader QUESTS_LOADER = new QuestsLoader();
    public static final Repository<Quest> QUEST_REPOSITORY = new QuestRepository();
    public static final AnswersRepository ANSWERS_REPOSITORY = new AnswersRepository();
    public static final QuestService QUEST_SERVICE = new QuestService(QUEST_REPOSITORY, ANSWERS_REPOSITORY, QUESTS_LOADER);
    public static final AnswerService ANSWER_SERVICE = new AnswerService(ANSWERS_REPOSITORY);
    public static final GameService GAME_SERVICE = new GameService(ANSWER_SERVICE);
}
