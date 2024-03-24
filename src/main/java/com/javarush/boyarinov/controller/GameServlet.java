package com.javarush.boyarinov.controller;

import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.service.GameService;
import com.javarush.boyarinov.service.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private final QuestService questService = new QuestService();
    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long questId = Long.parseLong(req.getParameter("questId"));
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        Quest quest = questService.get(questId);
        String question = gameService.getQuestion(quest, questionId);
        String pathToJsp = "%s/play-game.jsp".formatted(Constant.PATH_TO_VIEW_PACKAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pathToJsp);
        requestDispatcher.forward(req, resp);
    }
}
