<jsp:include page="header_worker.jsp"/>
<html>
<body>
<form action="/worker/update" th:object="${worker}" enctype="multipart/form-data" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Your name</label>
        <input type="email" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Your surname</label>
        <input type="email" class="form-control" name="surname" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Your experience</label>
        <input type="email" class="form-control" name="ex" id="exampleInputEmail2">
    </div>
    <div>
        <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="timeType">
            <option selected>Open this select menu</option>
            <option value="FULLTIME">FULLTIME</option>
            <option value="PARTTIME">PARTTIME</option>
            <option value="FIXED">FIXED</option>
            <option value="FLEXIBLE">FLEXIBLE</option>
            <option value="ROTATING">ROTATING</option>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>