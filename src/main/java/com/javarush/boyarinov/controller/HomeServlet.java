package com.javarush.boyarinov.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/", "/home", "/in-dev"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI().equals("/in-dev") ? "in-dev" : "home";
        String pathToJsp = "/WEB-INF/boyarinov/view/%s.jsp".formatted(requestURI);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(pathToJsp);
        requestDispatcher.forward(req, resp);

    }

}
