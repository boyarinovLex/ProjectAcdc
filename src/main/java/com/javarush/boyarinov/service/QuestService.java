package com.javarush.boyarinov.service;

import com.javarush.boyarinov.config.Container;
import com.javarush.boyarinov.config.UploadQuests;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.repository.AnswersRepository;
import com.javarush.boyarinov.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class QuestService {

    private final Repository<Quest> questRepository = Container.questRepository;

    private final AnswersRepository answersRepository = Container.answersRepository;

    private final UploadQuests uploadQuests = Container.uploadQuests;

    public Collection<Quest> getAll() {
        Collection<Quest> quests = questRepository.getAll();
        if (quests.isEmpty()) {
            doUpload();
        }
        return questRepository.getAll();
    }

    public Quest get(long id) {
        return questRepository.get(id);
    }

    public void create(Quest quest) {
        questRepository.create(quest);
    }

    public void update(Quest quest) {
        questRepository.update(quest);
    }

    public void delete(Quest quest) {
        questRepository.delete(quest);
    }

    private void doUpload() {
        uploadQuests.testYamlMapping();
        List<Quest> questList = uploadQuests.getQuests();
        List<Answers> answersList = uploadQuests.getAnswers();

        questList.forEach(this::create);
        answersList.forEach(answers -> {
            long questId = answers.getQuestId();
            answersRepository.create(questId, answers);
        });
    }
}
