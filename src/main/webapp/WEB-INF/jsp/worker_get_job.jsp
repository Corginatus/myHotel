
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
<%--    <c:if test="${worker.isEmployer()}">--%>
<%--        <td>${worker.getEmployer().getUsername()}</td>--%>
<%--        <td>--%>
<%--            <form action="/worker/kill_job" method="post">--%>
<%--                <input type="hidden" name="worker" value="${worker}"/>--%>
<%--                <button type="submit">Уволиться</button>--%>
<%--            </form>--%>
<%--        </td>--%>
<%--    </c:if>--%>
<%--    <c:if test="${!worker.isEmployer()}">--%>
    <table>
        <thead>
        <th>Available jobs</th>
        </thead>
        <c:forEach items="${ownerList}" var="owner">
            <tr>
                <td>${owner.getUsername()}</td>
                <td>
                    <form action="/worker/get_job" method="post">
                        <input type="hidden" name="owner" value="${owner.getId()}"/>
                        <button type="submit">Подать заявку</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--    </c:if>--%>
    <a href="/worker/home">Назад</a>
</div>
</body>
</html>