
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
    <table>
        <thead>
        <th>Мои работники</th>
        </thead>
        <c:forEach items="${workerList}" var="worker">
            <tr>
                <td>${worker.getUsername()}</td>
                <td>
                    <form action="/owner/workers" method="post">
                        <input type="hidden" name="worker" value="${worker.getId()}"/>
                        <button type="submit">Уволить</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/owner/home">Назад</a>
</div>
</body>
</html>