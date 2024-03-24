package com.javarush.boyarinov.model;

import lombok.Data;

import java.util.List;

@Data
public class Quest implements Model {

    private long id;

    private String name = "Тестовый квест";

    private List<String> questionsList = List.of("1. Вопрос первый?", "2. Вопрос второй?", "3. Вопрос третий?");

}
