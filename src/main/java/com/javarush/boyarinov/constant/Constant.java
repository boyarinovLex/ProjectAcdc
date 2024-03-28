package com.javarush.boyarinov.constant;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Objects;

public class Constant {

    private Constant() {
    }

    public static final String PATH_TO_VIEW_PACKAGE = "WEB-INF/boyarinov/view";

    public static final String PATH_TO_WEB_INF_BOYARINOV = Paths.get(URI.create(Objects.requireNonNull(Constant.class.getResource("/"))
            .toString())).getParent().toString() + "/boyarinov/";
}
