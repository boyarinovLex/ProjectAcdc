package com.javarush.boyarinov.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.javarush.boyarinov.util.UploadClassConverter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Answers {

    private long questionId = 0;

    private long questId = 1;

    @JsonDeserialize(converter = UploadClassConverter.class, contentConverter = UploadClassConverter.class)
    private Map<String, Boolean> answerMap = new HashMap<>() {{
        put("Answer 1", true);
        put("Answer 2", true);
        put("Answer 3", false);
    }};

}


