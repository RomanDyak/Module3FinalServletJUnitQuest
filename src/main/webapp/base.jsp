<%@ page import="com.javarush.module3final.entity.BaseEvent" %>
<%@ page import="com.javarush.module3final.entity.BaseAnswer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    BaseEvent event = (BaseEvent) session.getAttribute("event");
    String text = event.getText();
    List<BaseAnswer> answers = event.getActions();
    request.setAttribute("answerListEmpty", answers.isEmpty());
    request.setAttribute("answerList", answers);
%>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>Base!</h1>

<div><%= text %>
</div>
<c:if test="${!answerListEmpty}">
    <c:forEach items="${answerList}" var="answ">
    <div><a href="baseLogic?move=<c:out value="${answ.move}"/>"><c:out value="${answ.text}"/>
    </a></div>
    </c:forEach>
</c:if>
<div><a href="restart">К выбору квеста</a></div>
</body>
</html>
