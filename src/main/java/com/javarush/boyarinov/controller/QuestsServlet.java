package com.javarush.boyarinov.controller;

import com.javarush.boyarinov.config.Container;
import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.service.QuestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

@WebServlet(Constant.GO_QUESTS)
public class QuestsServlet extends HttpServlet {

    private final QuestService questService = Container.questService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Quest> quests = questService.getAll();

        req.setAttribute(Constant.QUESTS, quests);

        String pathToJsp = Constant.PATH_TO_VIEW_PACKAGE.formatted(Constant.GO_QUEST_LIST);
        req.getRequestDispatcher(pathToJsp).forward(req, resp);
    }

}
