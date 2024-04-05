package com.javarush.boyarinov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quest implements Model {

    private long id;

    private String name;

    private List<String> questionsList;

}
