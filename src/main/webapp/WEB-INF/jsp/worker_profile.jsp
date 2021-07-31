<%@ page import="com.myHotel.entity.Hotel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <thead>
    <th>My profile info</th>
    </thead>
</div>
<div>
    <jsp:text>Имя: </jsp:text>
    <td>${worker.name}</td>
</div>
<div>
    <jsp:text>Фамилия: </jsp:text>
    <td>${worker.surname}</td>
</div>
<div>
    <jsp:text>Опыт работы: </jsp:text>
    <td>${worker.ex}</td>
</div>
<div>
    <jsp:text>Рабочий день: </jsp:text>
    <td>${worker.timeType}</td>
</div>
<div>
    <a href="/worker/update">Обновить</a>
</div>
<div>
    <a href="/worker/home">Назад</a>
</div>
</body>
</html>