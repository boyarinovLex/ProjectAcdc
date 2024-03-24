package com.javarush.boyarinov.controller;

import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.service.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

@WebServlet("/quests")
public class QuestsServlet extends HttpServlet {

    private final QuestService questService = new QuestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Quest> quests = questService.getAll();
        req.setAttribute("quests", quests);

        String pathToJsp = "%s/quest-list.jsp".formatted(Constant.PATH_TO_VIEW_PACKAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pathToJsp);
        requestDispatcher.forward(req, resp);
    }

}
