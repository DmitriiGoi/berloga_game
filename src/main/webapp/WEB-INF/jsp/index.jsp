<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
<p>Пользователи</p>
<table>
    <tr>
        <td>Имя пользователя</td>
        <td>СИЛ</td>
        <td>ИНТ</td>
        <td>ЛВК</td>
        <td>ВЫН</td>
        <td>Выполненные задания</td>
        <td>Полученные достижения</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.userStats.strength}</td>
            <td>${user.userStats.intelligent}</td>
            <td>${user.userStats.dexterity}</td>
            <td>${user.userStats.constitution}</td>
            <td><c:forEach var="quest" items="${user.completedQuests}">
                <p2>${quest.quest.title}</p2>
                <br>
            </c:forEach></td>
            <td><c:forEach var="achievement" items="${user.unlockedAchievements}">
                <p2>${achievement.achievement.title}</p2>
                <br>
            </c:forEach></td>
        </tr>
    </c:forEach>
</table>

<p>Задания</p>
<table>
    <tr>
        <td>Название задания</td>
        <td>Описание задания</td>
        <td>Прибавка к аттрибуту</td>
        <td>Аттрибут</td>
    </tr>
    <c:forEach var="quest" items="${quests}">
        <tr>
            <td>${quest.title}</td>
            <td>${quest.description}</td>
            <td>${quest.incrementValue}</td>
            <td>${quest.mainAttribute.code}</td>
        </tr>
    </c:forEach>
</table>

<p>Достижения</p>
<table>
    <c:forEach var="achievement" items="${achievements}">
        <tr>
            <td>${achievement.title}</td>
            <td>${achievement.description}</td>
            <td>${achievement.attributeValue}</td>
            <td>${achievement.attribute.code}</td>
        </tr>
    </c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>