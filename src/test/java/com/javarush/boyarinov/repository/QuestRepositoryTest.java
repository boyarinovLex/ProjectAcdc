package com.javarush.boyarinov.repository;

import com.javarush.boyarinov.model.Quest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;


class QuestRepositoryTest {

    private final QuestRepository questRepository = new QuestRepository();
    private Quest quest;

    @BeforeEach
    void create() {
        quest = Quest.builder()
                .name("Quest 1")
                .questionsList(List.of("Question 1", "Question 2"))
                .build();
        questRepository.create(quest);
    }

    @Test
    void getAllTest() {
        //given
        Quest quest2 = Quest.builder()
                .name("Quest 2")
                .build();
        questRepository.create(quest2);
        //when
        Collection<Quest> actualQuests = questRepository.getAll();
        //then
        Assertions.assertEquals(2, actualQuests.size());
    }

    @Test
    void getTest() {
        //given
        long questId = 1;
        //when
        Quest actualQuest = questRepository.get(questId);
        //then
        Assertions.assertEquals(quest, actualQuest);
    }

    @Test
    void updateTest() {
        //given
        long questId = quest.getId();
        Quest expectedQuest = Quest.builder()
                .id(questId)
                .name("Quest 1")
                .questionsList(List.of("Question 3", "Question 4"))
                .build();
        //when
        questRepository.update(expectedQuest);
        //then
        Quest actualQuest = questRepository.get(questId);
        Assertions.assertEquals(expectedQuest, actualQuest);
    }

    @Test
    void delete() {
        //given
        long questId = quest.getId();
        //when
        questRepository.delete(quest);
        //then
        Quest actualQuest = questRepository.get(questId);

        Assertions.assertNull(actualQuest);

    }
}