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
public class QuestsLoader {

    private List<Quest> quests;

    private List<Answers> answers;

    public void yamlMapping() {
        ObjectMapper yamlMapper = new YAMLMapper();
        try {
            String pathToWebInfConfig = Constant.PATH_TO_WEB_INF_CONFIG;
            File pathForQuest = new File(pathToWebInfConfig + Constant.FILE_QUEST_LIST_YAML);
            File pathForAnswers = new File(pathToWebInfConfig + Constant.FILE_ANSWERS_LIST_YAML);

            quests = yamlMapper.readValue(pathForQuest, QuestList.class);
            answers = yamlMapper.readValue(pathForAnswers, AnswerList.class);
        } catch (NullPointerException | IOException e) {
            log.error(e);
            throw new AppException(e);
        }
    }
}

