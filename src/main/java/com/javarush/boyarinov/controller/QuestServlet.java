package com.javarush.boyarinov.controller;

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

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {

    private final QuestService questService = new QuestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Quest quest = new Quest();
        quest.setName("First");
        questService.create(quest);
        Collection<Quest> quests = questService.getAll();
        req.setAttribute("quests", quests);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/boyarinov/view/quest.jsp");
        requestDispatcher.forward(req, resp);
    }

}
