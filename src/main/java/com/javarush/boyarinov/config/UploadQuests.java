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
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
@Log4j2
public class UploadQuests {

    private List<Quest> quests;

    private List<Answers> answers;

    public void yamlMapping() {
        ObjectMapper yamlMapper = new YAMLMapper();
        try {
            String pathToWebInfBoyarinov = Constant.PATH_TO_WEB_INF_CONFIG;
            File pathForQuest = new File(pathToWebInfBoyarinov + Constant.FILE_QUEST_LIST_YAML);
            File pathForAnswers = new File(pathToWebInfBoyarinov + Constant.FILE_ANSWERS_LIST_YAML);

            quests = yamlMapper.readValue(pathForQuest, QuestList.class);
            answers = yamlMapper.readValue(pathForAnswers, AnswerList.class);
        } catch (NullPointerException | IOException e) {
            log.error(e);
            throw new AppException(e);
        }
    }
}

