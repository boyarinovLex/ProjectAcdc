package com.javarush.boyarinov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.exception.AppException;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.util.AnswerList;
import com.javarush.boyarinov.util.QuestList;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class UploadQuests {

    private List<Quest> quests;

    private List<Answers> answers;

    public void testYamlMapping() {
        ObjectMapper yamlMapper = new YAMLMapper();
        try {
            String pathToWebInfBoyarinov = Constant.PATH_TO_WEB_INF_CONFIG;
            File pathForQuest = new File(pathToWebInfBoyarinov + "questList.yml");
            File pathForAnswers = new File(pathToWebInfBoyarinov + "answersList.yml");

            quests = yamlMapper.readValue(pathForQuest, QuestList.class);
            answers = yamlMapper.readValue(pathForAnswers, AnswerList.class);
        } catch (NullPointerException | IOException e) {
            throw new AppException(e);
        }
    }

    private void createQuestsAndSerialize() {
        quests = new ArrayList<>();
        answers = new ArrayList<>();

        Quest quest1 = new Quest();
        quest1.setId(1);
        quest1.setName("Квест НЛО");
        List<String> questionList1 = List.of("Ты потерял память. Принять вызов НЛО?",
                "Ты принял вызов. Поднимается на мостик к капитану?", "Ты поднялся на мостик. Ты кто?");
        quest1.setQuestionsList(questionList1);

        quests.add(quest1);

        Answers answers1 = new Answers();
        answers1.setQuestionId(0);
        answers1.setQuestId(1);
        answers1.setLossMessage("Ты отклонил вызов. Поражение");
        answers1.setWinningMessage("");
        Map<String, Boolean> answersMap1 = Map.of("Принять вызов", true, "Отклонить вызов", false);
        answers1.setAnswerMap(answersMap1);

        Answers answers2 = new Answers();
        answers2.setQuestionId(1);
        answers2.setQuestId(1);
        answers2.setLossMessage("Ты не пошел на переговоры. Поражение");
        answers2.setWinningMessage("");
        Map<String, Boolean> answersMap2 = Map.of("Подняться на мостик", true, "Отказаться подниматься на мостик", false);
        answers2.setAnswerMap(answersMap2);

        Answers answers3 = new Answers();
        answers3.setQuestionId(2);
        answers3.setQuestId(1);
        answers3.setLossMessage("Твою ложь разоблачили. Поражение");
        answers3.setWinningMessage("Тебя вернули домой. Победа!");
        Map<String, Boolean> answersMap3 = Map.of("Рассказать правду о себе", true, "Солгать о себе", false);
        answers3.setAnswerMap(answersMap3);

        answers.add(answers1);
        answers.add(answers2);
        answers.add(answers3);

        try {
            ObjectMapper yamlMapper = new YAMLMapper();
            File pathForQuest = new File("questList.yml");
            File pathForAnswers = new File("answersList.yml");
            yamlMapper.writeValue(pathForQuest, quests);
            yamlMapper.writeValue(pathForAnswers, answers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

