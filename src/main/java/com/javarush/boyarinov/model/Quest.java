package com.javarush.boyarinov.model;

import lombok.Data;

import java.util.List;

@Data
public class Quest implements Model {

    private long id;

    private String name;

    private List<String> questionsList;

}
