<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<jsp:useBean id="answers" scope="request" type="com.javarush.boyarinov.model.Answers"/>

<div>
    <c:choose>
        <c:when test="${requestScope.message.length() > 0}">
            <div class="container">
                <p>${requestScope.message}</p>
                <form action="quests">
                    <input type="submit" value="Начать заново"/>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <div class="container">
                <h1>${requestScope.question}</h1>

                <form id="surveyForm" method="post"
                      action="game?questId=${answers.questId}&questionId=${answers.questionId}">
                    <c:forEach var="answer" items="${answers.answerMap}">
                        <label>
                            <input type="radio" name="answerValue" value="${answer.value}">
                        </label> ${answer.key}<br>
                    </c:forEach>
                    <input type="submit" value="Отправить">
                </form>

            </div>
        </c:otherwise>
    </c:choose>
</div>

<%@include file="parts/footer.jsp"%>