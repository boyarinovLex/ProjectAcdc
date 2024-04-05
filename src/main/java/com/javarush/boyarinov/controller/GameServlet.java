package com.javarush.boyarinov.controller;

import com.javarush.boyarinov.config.Container;
import com.javarush.boyarinov.constant.Constant;
import com.javarush.boyarinov.model.Answers;
import com.javarush.boyarinov.model.Quest;
import com.javarush.boyarinov.service.AnswerService;
import com.javarush.boyarinov.service.GameService;
import com.javarush.boyarinov.service.QuestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(Constant.GO_GAME)
public class GameServlet extends HttpServlet {

    private final QuestService questService = Container.questService;
    private final GameService gameService = Container.gameService;
    private final AnswerService answerService = Container.answerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long questId = Long.parseLong(req.getParameter(Constant.QUEST_ID));
        long questionId = Long.parseLong(req.getParameter(Constant.QUESTION_ID));
        boolean answerValue = Boolean.parseBoolean(req.getParameter(Constant.ANSWER_VALUE_FROM_JSP));

        String resultMessage = gameService.checkResultMessage(answerValue, questId, questionId);
        Quest quest = questService.get(questId);
        String question = gameService.getQuestion(quest, questionId);
        Answers answers = answerService.getAnswer(questId, questionId);

        req.setAttribute(Constant.QUESTION, question);
        req.setAttribute(Constant.ANSWERS, answers);
        req.setAttribute(Constant.RESULT_MESSAGE, resultMessage);

        String pathToJsp = Constant.PATH_TO_VIEW_PACKAGE.formatted(Constant.GO_PLAY_GAME);
        req.getRequestDispatcher(pathToJsp).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean answerValue = Boolean.parseBoolean(req.getParameter(Constant.ANSWER_VALUE));
        long questId = Long.parseLong(req.getParameter(Constant.QUEST_ID));
        long questionId = Long.parseLong(req.getParameter(Constant.QUESTION_ID));

        String pathToJsp = gameService.nextQuestion(answerValue, questId, questionId);

        resp.sendRedirect(pathToJsp);
    }
}
