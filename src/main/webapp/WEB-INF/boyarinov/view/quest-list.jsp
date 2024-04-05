<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>

<div>
    <c:forEach var="quest" items="${requestScope.quests}">
        <div class="container">
            <h2 class="container">${quest.name}</h2>
            <a href="game?questId=${quest.id}&questionId=0&value=true">
                <button>Играть</button>
            </a>
        </div>
    </c:forEach>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous">
</script>

<%@include file="parts/footer.jsp" %>

