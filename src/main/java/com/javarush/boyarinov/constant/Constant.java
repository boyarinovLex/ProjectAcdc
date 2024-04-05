package com.javarush.boyarinov.constant;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Objects;

public class Constant {

    private Constant() {
    }

    public static final String PATH_TO_VIEW_PACKAGE = "WEB-INF/boyarinov/view";

    public static final String PATH_TO_WEB_INF_CONFIG = Paths.get(URI.create(Objects.requireNonNull(Constant.class.getResource("/"))
            .toString())).getParent().toString() + "/boyarinov/config/";

    public static final String NO_QUEST = "Quest with ID %d does not exist";
    public static final String NO_QUEST_FOR_LOGGER = "Quest with ID {} does not exist";
    public static final String WRONG_DATA = "No answer or wrong data";
}
