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
    <th>Продаются отели:</th>
    <table>
        <thead>
        <th>Hotel name</th>
        </thead>
        <c:forEach items="${hotelList}" var="hotel">
            <tr>
                <td>${hotel.name}</td>

                <c:if test="${hotel.owner != 'myOwner'}">
                    <td>
                        <form action="/owner/hotel_free" method="post">
                            <input type="hidden" name="hotel" value="${hotel.id}"/>
                            <button type="submit">Купить</button>
                        </form>
                    </td>
                </c:if>
            </tr>

        </c:forEach>
    </table>
    <a href="/owner/home">Назад</a>
</div>
</body>
</html>