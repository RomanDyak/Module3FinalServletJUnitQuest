<%@ page import="com.javarush.module3final.entity.DiverEvent" %>
<%@ page import="com.javarush.module3final.entity.DiverAnswer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    DiverEvent event = (DiverEvent) session.getAttribute("event");
    String text = event.getText();
    List<DiverAnswer> answers = event.getActions();
    List<String> stats = (List<String>) session.getAttribute("statsList");
    request.setAttribute("answerListEmpty", answers.isEmpty());
    request.setAttribute("answerList", answers);
    request.setAttribute("statsList", stats);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Diver</h1>

<div><%= text %>
</div>
<c:if test="${!answerListEmpty}">
    <c:forEach items="${answerList}" var="answ">
        <div><a href="diverLogic?move=<c:out value="${answ.move}"/>"><c:out value="${answ.text}"/>
        </a></div>
    </c:forEach>
    <br>
</c:if>
<c:forEach items="${statsList}" var="stat">
    <div><c:out value="${stat}"/></div>
</c:forEach>

<div><br><a href="restart">К выбору квеста</a></div>
</body>
</html>
