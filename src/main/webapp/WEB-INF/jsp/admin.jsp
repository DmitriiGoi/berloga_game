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

<p style="margin-top: 0">Выполнить Задание</p>
<tr>
    <td><select id="questUser">
        <c:forEach items="${users}" var="user">
            <option id-value="${user.id}">${user.name}</option>
        </c:forEach>
    </select></td>
    <select id="questQuest">
        <c:forEach items="${quests}" var="quest">
            <option id-value="${quest.id}">${quest.title}</option>
        </c:forEach>
    </select></td>
    <td>
        <button id="completeQuest" onClick="completeQuest()">Выполнить</button>
    </td>
</tr>

<div></div>
<p>Задания</p>
<table>
    <c:forEach var="quest" items="${quests}">
        <tr>
            <td>${quest.title}</td>
            <td>${quest.description}</td>
            <td>${quest.incrementValue}</td>
            <td>${quest.mainAttribute.code}</td>
            <td>
                <button id-value="${quest.id}" id="deleteQuestButton" onClick="deleteQuest()">Удалить</button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><input type="text" placeholder="Название задания" id="questName"/></td>
        <td><input type="text" placeholder="Описание задания" id="questDescription"/></td>
        <td><input type="number" placeholder="Стоимость задания" id="questBonusValue"/></td>
        <td><select id="questAttribute">
            <c:forEach items="${attributes}" var="attribute">
                <option id-value="${attribute.name}">${attribute.code}</option>
            </c:forEach>
        </select></td>
        <td>
            <button id="createQuest" onClick="createQuest()">Сохранить</button>
        </td>
    </tr>
</table>

<div></div>
<p>Достижения</p>
<table>
    <c:forEach var="achievement" items="${achievements}">
        <tr>
            <td>${achievement.title}</td>
            <td>${achievement.description}</td>
            <td>${achievement.attributeValue}</td>
            <td>${achievement.attribute.code}</td>
            <td>
                <button id="deleteAchievementButton" id-value="${achievement.id}" onClick="deleteAchievement()">
                    Удалить
                </button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><input type="text" placeholder="Название достижения" id="achievementName"/></td>
        <td><input type="text" placeholder="Описание достижения" id="achievementDescription"/></td>
        <td><input type="number" placeholder="Стоимость достижения" id="achievementValue"/></td>
        <td><select id="achievementAttribute">
            <c:forEach items="${attributes}" var="attribute">
                <option id-value="${attribute.name}">${attribute.code}</option>
            </c:forEach>
        </select></td>
        <td>
            <button id="createAchievement" onClick="createAchievement()">Сохранить</button>
        </td>
    </tr>
</table>

<div></div>
<p>Пользователи</p>
<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>***</td>
            <td>
                <button id="deleteUserButton" id-value="${user.id}" id="deleteUserButton" onClick="deleteUser()">
                    Удалить
                </button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td><input type="text" placeholder="Имя пользователя" id="userName"/></td>
        <td><input type="text" placeholder="Логин пользователя" id="userLogin"/></td>
        <td><input type="text" placeholder="Пароль пользователя" id="userPassword"/></td>
        <td>
            <button id="createUser" onClick="createUser()">Сохранить</button>
        </td>
    </tr>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>