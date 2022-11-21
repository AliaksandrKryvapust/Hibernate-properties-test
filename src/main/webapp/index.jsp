<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Главная страница сервера</title>
</head>
<body>

<p>Ты можешь:</p>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signUp';" value="Зарегистрироваться" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signIn';" value="Войти" /></p>
    </c:when>
    <c:otherwise>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/structure';" value="Посмотреть структуру" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/profile';" value="Посмотреть информацию о себе" /></p>
<%--        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/logout';" value="Выйти" /></p>--%>
    </c:otherwise>
</c:choose>
</body>
</html>