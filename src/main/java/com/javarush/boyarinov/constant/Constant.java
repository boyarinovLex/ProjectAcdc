package com.javarush.boyarinov.constant;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Objects;

public final class Constant {

    private Constant() {
    }

    public static final String PATH_TO_JSP = "WEB-INF/boyarinov/view/%s.jsp";
    public static final String SEND_PATH_TO_NEXT_QUESTION = "game?questId=%d&questionId=%d&answer_value=%b";
    public static final String PATH_TO_WEB_INF_CONFIG = Paths.get(URI.create(Objects.requireNonNull(Constant.class.getResource("/"))
            .toString())).getParent().toString() + "/boyarinov/config/";
    public static final String FILE_QUEST_LIST_YAML = "questList.yml";
    public static final String FILE_ANSWERS_LIST_YAML = "answersList.yml";

    public static final String NO_QUEST = "Quest with ID %d does not exist";
    public static final String NO_QUEST_FOR_LOGGER = "Quest with ID {} does not exist";
    public static final String WRONG_DATA = "No answer or wrong data";
    public static final String QUEST_ID = "questId";
    public static final String QUESTION_ID = "questionId";
    public static final String QUESTION = "question";
    public static final String QUESTS = "quests";
    public static final String ANSWERS = "answers";
    public static final String RESULT_MESSAGE = "resultMessage";
    public static final String ANSWER_VALUE = "answerValue";
    public static final String ANSWER_VALUE_FROM_JSP = "answer_value";

    public static final String GO_EMPTY_SLASH = "/";
    public static final String GO_HOME = "/home";
    public static final String GO_IN_DEV = "/in-dev";
    public static final String GO_QUESTS = "/quests";
    public static final String GO_GAME = "/game";
    public static final String GO_PLAY_GAME = "play-game";
    public static final String GO_QUEST_LIST = "quest-list";


}
