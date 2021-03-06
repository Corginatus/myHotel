
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
    <th>Jobs</th>
    </thead>
</div>
<div>
    <jsp:text>Рабочих мест: </jsp:text>
    <td>${owner.getWorkplace()}</td>
</div>
<div>
    <jsp:text>Свободных рабочих мест: </jsp:text>
    <td>${owner.getFreeWorkplace()}</td>
</div>

<div>
    <a href="/owner/del_job">Убрать одно место</a>
</div>
<div>
    <a href="/owner/give_job">Добавить одно место</a>
</div>
<div>
    <a href="/owner/home">Назад</a>
</div>
</body>
</html>