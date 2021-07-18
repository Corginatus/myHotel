<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Date</th>
        <th scope="col">Hotel name</th>
        <th scope="col">Buyer</th>
        <th scope="col">Seller</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="myhotels" items="${hotels}">
        <tr>
            <th scope="row">${myhotels.id}</th>
            <td>${myhotels.date}</td>
            <td>${myhotels.hotel.name}</td>
            <td>${myhotels.buyer.username}</td>
            <td>${myhotels.seller.username}</td>
        </tr>
    </c:forEach>
    </tbody>
    <a href="/admin">Назад</a>
</table>