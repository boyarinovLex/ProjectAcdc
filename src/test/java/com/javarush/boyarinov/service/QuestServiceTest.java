package com.javarush.boyarinov.service;

import com.javarush.boyarinov.config.QuestsLoader;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.repository.AnswersRepository;
import com.javarush.boyarinov.repository.QuestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;


class QuestServiceTest {

    private final QuestRepository questRepository = Mockito.mock(QuestRepository.class);

    private final AnswersRepository answersRepository = Mockito.mock(AnswersRepository.class);

    private final QuestsLoader questsLoader = Mockito.mock(QuestsLoader.class);

    private final QuestService questService = new QuestService(questRepository, answersRepository, questsLoader);

    private Quest quest;

    @BeforeEach
    void setUp() {
        quest = Quest.builder()
                .id(1L)
                .name("Quest 1")
                .questionsList(List.of("Question 1", "Question 2", "Question 3"))
                .build();
    }

    @Test
    void getAllTest() {
        //when
        Mockito.when(questRepository.getAll()).thenReturn(List.of(quest));
        Collection<Quest> quests = questService.getAll();
        //then
        Assertions.assertEquals(1, quests.size());
        Mockito.verify(questRepository, Mockito.times(2)).getAll();
    }

    @Test
    void whenNeedUploadQuests() {
        //when
        questService.getAll();
        //then
        Mockito.verify(questsLoader).yamlMapping();
    }

    @Test
    void getTest() {
        //given
        long questId = quest.getId();
        //when
        Mockito.when(questRepository.get(questId)).thenReturn(quest);
        Quest actualQuest = questService.get(questId);
        //then
        Assertions.assertEquals(quest, actualQuest);
    }

    @Test
    void createTest() {
        //when
        questService.create(quest);
        //then
        Mockito.verify(questRepository).create(quest);
    }

    @Test
    void update() {
        //when
        questService.update(quest);
        //then
        Mockito.verify(questRepository).update(quest);
    }

    @Test
    void delete() {
        //when
        questService.delete(quest);
        //then
        Mockito.verify(questRepository).delete(quest);
    }
}