package com.javarush.boyarinov.model;

import lombok.Data;

import java.util.List;

@Data
public class User implements Model {

    private long id;

    private String name;

    private String login;

    private String password;

    private List<Quest> questList;

}
