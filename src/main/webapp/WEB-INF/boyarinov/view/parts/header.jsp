<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Quest game</title>
</head>

<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="home" class="nav-link px-2 text-secondary">Домой</a></li>
                <li><a href="in-dev" class="nav-link px-2 text-white">Статистика</a></li>
                <li><a href="quests" class="nav-link px-2 text-white">Квесты</a></li>
                <li><a href="in-dev" class="nav-link px-2 text-white">Пользователи</a></li>
                <li><a href="in-dev" class="nav-link px-2 text-white">Создать квест</a></li>
            </ul>

            <div class="text-end" style="display: none">
                <button type="button" class="btn btn-outline-light me-2">Login</button>
                <button type="button" class="btn btn-warning">Sign-up</button>
            </div>
        </div>
    </div>
</header>
