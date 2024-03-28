package com.javarush.boyarinov.service;

import com.javarush.boyarinov.config.Container;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.repository.AnswersRepository;

import java.util.List;

public class AnswerService {

    private final AnswersRepository answersRepository = Container.answersRepository;

    public void create(long questId, Answers answers) {
        answersRepository.create(questId, answers);
    }

    public Answers getAnswer(long questId, long questionId) {
        return answersRepository.getAnswer(questId, questionId);
    }

    public List<Answers> getAll(long questId) {
        return answersRepository.getAll(questId);
    }

    public void update(long questId, long questionId, Answers answers) {
        answersRepository.update(questId, questionId, answers);
    }

    public void remove(long questId, long questionId) {
        answersRepository.remove(questId, questionId);
    }
}
