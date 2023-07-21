<%@ page import="com.javarush.module3final.entity.base.BaseEvent" %>
<%@ page import="com.javarush.module3final.entity.base.BaseAnswer" %>
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
    <title>BaseQuest</title>
    <link href="static/main.css" rel="stylesheet">
</head>
<body>
<h1>Base!</h1>

<div class="textBlock"><%= text %>
</div>
<div class="answerBlock">
<c:if test="${!answerListEmpty}">
    <c:forEach items="${answerList}" var="answ">
    <div><a href="baseLogic?move=<c:out value="${answ.move}"/>"><c:out value="${answ.text}"/>
    </a></div>
    </c:forEach>
</c:if>
</div>
<br>
<%--<div><button id="buttonRestart"><a href="restart"></a></button></div>--%>
<div><a class="button" href="restart" style="--color:#ff1867;">
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    НАЧАТЬ СНАЧАЛА!
</a></div>
</body>
</html>
