package com.javarush.boyarinov.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.javarush.boyarinov.model.Answers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadClassConverter implements Converter<Map<String, List<Answers>>, Map<String, List<Answers>>> {

    @Override
    public Map<String, List<Answers>> convert(Map<String, List<Answers>> map) {
        return new HashMap<>(map);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructMapType(Map.class, String.class, List.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructMapType(Map.class, String.class, List.class);
    }
}
