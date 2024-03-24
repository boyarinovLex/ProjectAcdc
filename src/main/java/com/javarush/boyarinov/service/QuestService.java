package com.javarush.boyarinov.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.repository.QuestRepository;
import com.javarush.boyarinov.repository.Repository;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

@AllArgsConstructor
public class QuestService {

    private final Repository<Quest> questRepository = new QuestRepository();

    //TODO: вернуть метод в исходное состояние
    public Collection<Quest> getAll() {
        Collection<Quest> quests = questRepository.getAll();
        if (quests.isEmpty()) {
            Quest quest = new Quest();
            quest.setName("First");
            create(quest);
        }
        return quests;
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

}
