package com.javarush.boyarinov.service;

import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.repository.QuestRepository;
import com.javarush.boyarinov.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class QuestService {

    private final Repository<Quest> questRepository = new QuestRepository();

    public Collection<Quest> getAll() {
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
}
