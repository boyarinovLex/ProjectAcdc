package com.javarush.boyarinov.repository;

import com.javarush.boyarinov.exception.AppException;
import com.javarush.boyarinov.model.Answers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class AnswersRepository {

    private final Map<Long, List<Answers>> answerMap = new ConcurrentHashMap<>();


    public void create(long questId, Answers answers) {
        List<Answers> answersList = answerMap.get(questId);
        if (answersList.isEmpty()) {
            answersList = new ArrayList<>();
        }
        answersList.add(answers);
        answerMap.put(questId, answersList);
    }

    public Answers getAnswer(long questId, long questionId) {
        List<Answers> answersList = answerMap.get(questId);
        Optional<Answers> answerOptional = answersList.stream()
                .filter(a -> a.getQuestionId() == questionId)
                .findAny();
        if (answerOptional.isEmpty()) {
            throw new AppException("No answer");
        }
        return answerOptional.get();
    }

    public List<Answers> getAll(long questId) {
        return answerMap.get(questId);
    }

    public void update(long questId, long questionId, Answers answers) {
        List<Answers> answersList = answerMap.get(questId);
        remove(questId, questionId);
        answersList.add(answers);
        answerMap.put(questId, answersList);
    }

    public void remove(long questId, long questionId) {
        Answers answerToDelete = getAnswer(questId, questionId);
        List<Answers> answersList = answerMap.get(questId);
        answersList.remove(answerToDelete);
    }
}
