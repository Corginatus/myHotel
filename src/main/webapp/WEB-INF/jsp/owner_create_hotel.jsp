<jsp:include page="header_owner.jsp"/>
<html>
<body>
<form action="/owner/create_hotel" th:object="${owner}" enctype="multipart/form-data" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Hotel name</label>
        <input type="email" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">you can't change username after registration</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Count of rooms</label>
        <input type="email" class="form-control" name="rooms" id="exampleInputPassword1">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>