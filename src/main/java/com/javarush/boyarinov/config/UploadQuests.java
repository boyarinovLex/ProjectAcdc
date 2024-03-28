package com.javarush.boyarinov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.exception.AppException;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.service.AnswerService;
import com.javarush.boyarinov.service.QuestService;
import com.javarush.boyarinov.util.AnswerList;
import com.javarush.boyarinov.util.QuestList;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Data
public class UploadQuests {

    private List<Quest> quests;

    private List<Answers> answers;

    public void testYamlMapping() {
        ObjectMapper yamlMapper = new YAMLMapper();
        try {

            String pathToWebInfBoyarinov = Constant.PATH_TO_WEB_INF_BOYARINOV;
            File pathForQuest = new File(pathToWebInfBoyarinov + "questList.yml");
            File pathForAnswers = new File(pathToWebInfBoyarinov + "answersList.yml");

            quests = yamlMapper.readValue(pathForQuest, QuestList.class);
            answers = yamlMapper.readValue(pathForAnswers, AnswerList.class);

        } catch (NullPointerException | IOException e) {
            throw new AppException(e);
        }
    }

    private void createQuests() {
        Quest quest1 = new Quest();
        Quest quest2 = new Quest();
        quest1.setName("Квест 1");
        quest2.setName("Квест 2");
        List<String> questionList1 = List.of("Вопрос 1", "Вопрос 2", "Вопрос 3");
        List<String> questionList2 = List.of("Вопрос 1", "Вопрос 2", "Вопрос 3");
        quest1.setQuestionsList(questionList1);
        quest2.setQuestionsList(questionList2);
        QuestService questService = Container.questService;
        questService.create(quest1);
        questService.create(quest2);

        Answers answers1 = new Answers();
        answers1.setQuestionId(0);
        answers1.setQuestId(1);
        Map<String, Boolean> answersMap1 = Map.of("Answer 1", true, "Answer 2", false, "Answer 3", false);
        answers1.setAnswerMap(answersMap1);
        AnswerService answerService = Container.answerService;
        answerService.create(answers1.getQuestId(), answers1);

        Answers answers2 = new Answers();
        answers2.setQuestionId(1);
        answers2.setQuestId(1);
        Map<String, Boolean> answersMap2 = Map.of("Answer 1", false, "Answer 2", true, "Answer 3", false);
        answers2.setAnswerMap(answersMap2);
        answerService.create(answers2.getQuestId(), answers2);
    }
}

