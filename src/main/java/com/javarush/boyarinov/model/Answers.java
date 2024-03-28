package com.javarush.boyarinov.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Answers {

    private long questionId;

    private long questId;

    //@JsonDeserialize(converter = UploadClassConverter.class)
    private Map<String, Boolean> answerMap = new HashMap<>();

}


