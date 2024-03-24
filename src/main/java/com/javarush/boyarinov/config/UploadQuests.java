package com.javarush.boyarinov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadQuests {

    private List<Quest> quests;

    private List<Answers> answers;


    public void testYamlMapping() throws IOException {
        ObjectMapper yamlMapper = new YAMLMapper();

        File pathForQuest = new File("quest.yml");
        File pathForAnswers = new File("answers.yml");
        quests = yamlMapper.readValue(pathForQuest, List.class);
        answers = yamlMapper.readValue(pathForAnswers, List.class);

    }
}

