package com.javarush.boyarinov.repository;

import com.javarush.boyarinov.exception.AppException;
import com.javarush.boyarinov.model.Answers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AnswersRepository {

    private final Map<Long, List<Answers>> answerMap = new ConcurrentHashMap<>();

    public void create(long questId, Answers answers) {
        List<Answers> answersList = answerMap.get(questId);
        if (Objects.isNull(answersList)) {
            answersList = new ArrayList<>();
        }
        answersList.add(answers);
        answerMap.put(questId, answersList);
    }

    public Answers getAnswers(long questId, long questionId) {
        List<Answers> answersList = getAnswersList(questId);
        Optional<Answers> answerOptional = answersList.stream()
                .filter(a -> a.getQuestionId() == questionId)
                .findAny();
        if (answerOptional.isEmpty()) {
            throw new AppException("No answer or wrong data");
        }
        return answerOptional.get();
    }

    public List<Answers> getAll(long questId) {
        return answerMap.get(questId);
    }

    public void update(long questId, long questionId, Answers answers) {
        List<Answers> answersList = getAnswersList(questId);
        remove(questId, questionId);
        answersList.add(answers);
        answerMap.put(questId, answersList);
    }

    public void remove(long questId, long questionId) {
        Answers answerToDelete = getAnswers(questId, questionId);
        List<Answers> answersList = answerMap.get(questId);
        answersList.remove(answerToDelete);
    }

    private List<Answers> getAnswersList(long questId) {
        List<Answers> answersList = answerMap.get(questId);
        if (Objects.isNull(answersList)) {
            throw new AppException("Quest with ID %d does not exist".formatted(questId));
        }
        return answersList;
    }
}
