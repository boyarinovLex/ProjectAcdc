package com.javarush.boyarinov.controller;

import com.javarush.boyarinov.constant.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({Constant.GO_EMPTY_SLASH, Constant.GO_HOME, Constant.GO_IN_DEV})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI().equals(Constant.GO_IN_DEV)
                ? Constant.GO_IN_DEV
                : Constant.GO_HOME;
        String pathToJsp = Constant.PATH_TO_JSP.formatted(requestURI.substring(1));
        req.getRequestDispatcher(pathToJsp).forward(req, resp);

    }

}
