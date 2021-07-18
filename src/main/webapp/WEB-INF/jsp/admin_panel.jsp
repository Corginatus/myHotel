<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>

    <h4><a href="/admin/users">Пользователи</a></h4>
    <h4><a href="/admin/hotels">Отели</a></h4>
    <h4><a href="/admin/hotel_add">Добавить отель</a></h4>
    <h4><a href="/admin/hotel_history">История продаж/покупок</a></h4>
    <a href="/">Главная</a>
</div>
</body>
</html>