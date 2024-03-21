<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="header.jsp" %>
<div>
    <c:forEach var="quest" items="${requestScope.quests}">
        <div class="container">
            <h3 class="container">${quest.name}</h3>
        </div>
    </c:forEach>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

