<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<jsp:useBean id="answers" scope="request" type="com.javarush.boyarinov.model.Answers"/>

<div>
    <c:choose>
        <c:when test="${requestScope.resultMessage.length() > 0}">
            <div class="container">
                <h2>${requestScope.resultMessage}</h2>
                <form action="quests">
                    <button type="submit">Начать заново</button>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <div class="container">
                <h1>${requestScope.question}</h1>

                <form id="surveyForm" method="post"
                      action="game?questId=${answers.questId}&questionId=${answers.questionId}">
                    <c:forEach var="answer" items="${answers.answerMap}">
                        <input id="radio" type="radio" name="answerValue" value="${answer.value}"
                               onchange="document.getElementById('submit').disabled = !this.checked;">
                        <label for="radio">${answer.key}</label><br>
                    </c:forEach>
                    <input id="submit" disabled="disabled" name="submit" type="submit" value="Отправить">
                </form>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<%@include file="parts/footer.jsp" %>