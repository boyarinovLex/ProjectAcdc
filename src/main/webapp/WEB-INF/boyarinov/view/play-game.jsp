<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<jsp:useBean id="answers" scope="request" type="com.javarush.boyarinov.model.Answers"/>


<div>
    <h1>${requestScope.question}</h1>

    <form id="surveyForm" method="post" action="game?questId=${answers.questId}&questionId=${answers.questionId}">
        <c:forEach var="answer" items="${answers.answerMap}">
            <label>
                <input type="radio" name="answerValue" value="${answer.value}">
            </label> ${answer.key}<br>
        </c:forEach>
        <input type="submit" value="Отправить">
    </form>

</div>
