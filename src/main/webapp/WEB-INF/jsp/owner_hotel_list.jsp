<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header_owner.jsp"/>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Hotel name</th>
        <th scope="col">Rooms</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hotel" items="${hotelList}">
        <tr>
            <th scope="row">${hotel.id}</th>
            <td>${hotel.name}</td>
            <td>${hotel.rooms}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>