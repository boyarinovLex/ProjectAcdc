package com.javarush.boyarinov.controller;

import com.javarush.boyarinov.config.Container;
import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.service.AnswerService;
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

    private final QuestService questService = Container.questService;
    private final GameService gameService = Container.gameService;
    private final AnswerService answerService = Container.answerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long questId = Long.parseLong(req.getParameter("questId"));
        long questionId = Long.parseLong(req.getParameter("questionId"));
        boolean value = Boolean.parseBoolean(req.getParameter("value"));
        String message = gameService.checkMessage(value, questId, questionId);
        Quest quest = questService.get(questId);
        String question = gameService.getQuestion(quest, questionId);
        Answers answers = answerService.getAnswer(questId, questionId);
        req.setAttribute("question", question);
        req.setAttribute("answers", answers);
        req.setAttribute("message", message);

        String pathToJsp = "%s/play-game.jsp".formatted(Constant.PATH_TO_VIEW_PACKAGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pathToJsp);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean answerValue = Boolean.parseBoolean(req.getParameter("answerValue"));
        long questId = Long.parseLong(req.getParameter("questId"));
        long questionId = Long.parseLong(req.getParameter("questionId"));
        long nextQuestionId = gameService.nextQuestion(answerValue, questId, questionId);

        String pathToJsp = nextQuestionId > 0
                ? "/game?questId=%d&questionId=%d&value=true".formatted(questId, nextQuestionId)
                : "/game?questId=%d&questionId=%d&value=false".formatted(questId, questionId);
        resp.sendRedirect(pathToJsp);
    }
}
